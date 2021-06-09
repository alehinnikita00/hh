package Controller;

import Dao.EmployeeDao;
import Model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private VBox btnList;
    @FXML
    private Button users;
    @FXML
    private VBox userList;
    @FXML
    private ScrollPane pane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double widht = Screen.getPrimary().getBounds().getWidth();
        btnList.setMinWidth(widht*0.1);
        pane.setMinWidth(widht * 0.9);

    }

    public void click(ActionEvent event) {
        users.setText("click");
        List<Employee> employees = new ArrayList<>();
        EmployeeDao employeeDao = new EmployeeDao();
        try {
            employees = employeeDao.getAllOrderLastEnter();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        for(int i = 0; i < employees.stream().count(); i++){
            Button button = new Button();
            button.setText(employees.get(i).getLastEnter() + " " + i);

            userList.getChildren().add(button);
        }
        double widht = Screen.getPrimary().getBounds().getWidth();
        users.setText(String.valueOf(widht));

    }

    public void scroll(ScrollEvent scrollEvent) {
        double widht = Screen.getPrimary().getOutputScaleX();
        userList.setMinWidth(widht * 0.8);
    }
}
