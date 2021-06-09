package Controller;

import Dao.UserDao;
import Model.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginController {
    @FXML
    private TextField loginField;
    @FXML
    private TextField passFiled;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginLabel;
    @FXML
    private Label passLabel;


    public void login(ActionEvent actionEvent) throws Exception{

        UserDao userDao = new UserDao();
        User user = userDao.getByLoginPassword(loginField.getText(), passFiled.getText());
        if(user != null) loginButton.setText("accepted");


    }
}
