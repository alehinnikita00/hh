package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

public class LaborantController implements Initializable {
    @FXML
    private Button create;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField field;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

}
