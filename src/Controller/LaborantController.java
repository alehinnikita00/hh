package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LaborantController {
    @FXML
    private Button create;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField field;

    public void createBarcode(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        List<Integer> numbers = new ArrayList<>();
        char[] arr = field.getText().toCharArray();
        for(int i = 0; i < arr.length; i++){
            String a = String.valueOf( arr[i]);
            numbers.add(Integer.parseInt(a));
        }
        double lastX = 0;
        double lastY = 0;
        for (int i = 0; i < numbers.stream().count(); i++){
            if(i == 0){
                gc.beginPath();
                gc.setLineWidth(numbers.get(i) * 15);
                gc.moveTo(0, 0);
                gc.lineTo(0,260);
                lastX = numbers.get(i) * 15 + 20;
                lastY = 15;
                gc.stroke();
                gc.closePath();
            }
            else {
                gc.beginPath();
                gc.setLineWidth(numbers.get(i) * 15);
                gc.moveTo(lastX, 0);
                gc.lineTo(lastX, 260 - lastY);
                lastX = lastX + numbers.get(i)*15 + 20;
                gc.stroke();
                gc.closePath();
            }

        }
    }
}
