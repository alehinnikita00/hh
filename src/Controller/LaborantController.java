package Controller;

import Dao.InsuranceDao;
import Dao.PatientDao;
import Dao.SocialDao;
import Dao.UserDao;
import Model.Insurance;
import Model.Patient;
import Model.Social;
import Model.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class LaborantController implements Initializable {
    @FXML
    private Button createOrder;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField field;
    @FXML
    private VBox fontMenu;
    @FXML
    private VBox pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double widht = Screen.getPrimary().getBounds().getWidth();
        double height = Screen.getPrimary().getBounds().getHeight();
        for (int i = 0; i < fontMenu.getChildren().stream().count(); i++){
            fontMenu.getChildren().get(i).setStyle("-fx-min-width: " + 230 );
        }

    }


    public void createBarcode(ActionEvent event) {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        List<Integer> numbers = new ArrayList<>();
        char[] arr = field.getText().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            String a = String.valueOf(arr[i]);
            numbers.add(Integer.parseInt(a));
        }
        double lastX = 36.3;
        for (int i = 0; i < numbers.stream().count(); i++) {
            if (i == 0 || i == numbers.stream().count() - 1 || i == numbers.stream().count() / 2) {
                gc.beginPath();
                gc.fillRect(lastX, 0, numbers.get(i) * 1.5, 32);
                gc.setFont(new Font(4));
                gc.strokeText(String.valueOf(numbers.get(i)), lastX - 1, 30);
                lastX = lastX + numbers.get(i) * 1.5 + 2;
                gc.closePath();
            } else {
                if (numbers.get(i) == 0) {
                    gc.beginPath();
                    gc.setFont(new Font(4));
                    gc.strokeText(String.valueOf(numbers.get(i)), lastX - 1, 30);
                    lastX = lastX + 1.35 + 2;
                    gc.closePath();
                }
                gc.beginPath();
                gc.fillRect(lastX, 0, numbers.get(i) * 1.5, 26);
                gc.setFont(new Font(4));
                gc.strokeText(String.valueOf(numbers.get(i)), lastX - 1, 30);
                lastX = lastX + numbers.get(i) * 1.5 + 2;
                gc.closePath();
            }
        }
    }

    public void createOrders(ActionEvent actionEvent) {
        pane.getChildren().removeAll(pane.getChildren());
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        Tooltip firstTool = new Tooltip();
        Tooltip lastTool = new Tooltip();
        PatientDao patientDao = new PatientDao();
        firstName.setTooltip(firstTool);
        lastName.setTooltip(lastTool);


        firstName.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    lastTool.setText("");
                    firstTool.setText("");
                    try {
                        List<Patient> patients = patientDao.getPatientByName(firstName.getText(), lastName.getText());
                        for(int i = 0; i < patients.stream().count(); i++){
                            System.out.println(i);
                            firstTool.setText( firstTool.getText() + patients.get(i).getUser().getFirst_name() + "\n");
                            lastTool.setText(lastTool.getText() + patients.get(i).getUser().getLast_name() + "\n");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ;
                });
        lastName.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    lastTool.setText("");
                    firstTool.setText("");
                    try {
                        List<Patient> patients = patientDao.getPatientByName(firstName.getText(), lastName.getText());
                        for(int i = 0; i < patients.stream().count(); i++){
                            System.out.println(i);
                            firstTool.setText( firstTool.getText() + patients.get(i).getUser().getFirst_name() + "\n");
                            lastTool.setText(lastTool.getText() + patients.get(i).getUser().getLast_name() + "\n");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ;
                });


        ObservableList<String> list = FXCollections.observableArrayList("1", "2", "3");

        ComboBox servicesBox = new ComboBox(list);
        pane.getChildren().addAll(firstName, lastName, servicesBox);
    }

    public void createPatient(ActionEvent actionEvent) {
        pane.getChildren().removeAll(pane.getChildren());
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField pass_s = new TextField();
        TextField pass_n = new TextField();
        TextField phone = new TextField();
        TextField email = new TextField();
        TextField social = new TextField();
        ChoiceBox social_type = new ChoiceBox();
        social_type.getItems().addAll("oms", "dms");
        TextField insurance = new TextField();
        Tooltip insTool = new Tooltip();
        firstName.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    insTool.setText("");
                    try {
                        InsuranceDao insuranceDao = new InsuranceDao();
                        List<Insurance> insurances= insuranceDao.getByNameLike(insurance.getText());
                        for(int i = 0; i < insurances.stream().count(); i++){
                            insTool.setText( insTool.getText() + insurances.get(i).getName() + "\n");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ;
                });


        Button create = new Button();
        create.setOnAction(e->{
            try {
                UserDao userDao = new UserDao();
                PatientDao patientDao = new PatientDao();
                int id = userDao.getLastId() + 1;
                SocialDao socialDao = new SocialDao();
                InsuranceDao insuranceDao =new InsuranceDao();
                userDao.createUser( new User(id, firstName.getText(), lastName.getText(), firstName.getText(), lastName.getText(), ""));
                System.out.println("create user");
                User user = userDao.getById(id);
                socialDao.create(new Social(social.getText(), social_type.getValue().toString(), insuranceDao.getByName(insurance.getText())));
                patientDao.create(new Patient(UUID.randomUUID().toString(), user, socialDao.getOneByNumber(social.getText()),
                        "", pass_s.getText(), pass_n.getText(), email.getText(), phone.getText(), " "));
                create.setText("created");
            } catch (Exception ex){System.out.println(ex.getMessage());}
        });
        pane.getChildren().addAll(new Label("fname"), firstName,new Label("lname"), lastName,
                new Label("pass_S" ), pass_s, new Label("pass_n"), pass_n,
                new Label("email"),email, new Label("phone"), phone,
                new Label("social number"), social,  social_type, new Label("inurance"), insurance, create);
     }
}
