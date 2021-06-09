package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

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
            if(i ==0 || i == numbers.stream().count() -1 || i == numbers.stream().count()/2){
                gc.beginPath();
                gc.fillRect(lastX, 0, numbers.get(i) * 1.5, 32);
                gc.setFont(new Font(4));
                gc.strokeText(String.valueOf(numbers.get(i)), lastX -1, 30);
                lastX = lastX+ numbers.get(i)*1.5 + 2;
                gc.closePath();
            }
            else {
                if(numbers.get(i) == 0){
                    gc.beginPath();
                    gc.setFont(new Font(4));
                    gc.strokeText(String.valueOf(numbers.get(i)), lastX - 1, 30);
                    lastX = lastX+ 1.35 + 2;
                    gc.closePath();
                }
                gc.beginPath();
                gc.fillRect(lastX, 0, numbers.get(i) * 1.5, 26);
                gc.setFont(new Font(4));
                gc.strokeText(String.valueOf(numbers.get(i)), lastX - 1, 30);
                lastX = lastX+ numbers.get(i)*1.5 + 2;
                gc.closePath();
            }



            /*if (i == 0) {
                gc.beginPath();
                gc.setLineWidth(numbers.get(i) * 15);
                gc.moveTo(0, 280);
                gc.lineTo(0, 0);
                gc.stroke();
                gc.setLineWidth(1.0);
                gc.setFont(new Font(20));
                gc.strokeText(String.valueOf(numbers.get(i)), lastX - 22, 300);
                lastX = numbers.get(i) * 15 + 20;
                gc.closePath();
            }*/
            /*if (i == numbers.stream().count()) {

            }
            else {
                gc.beginPath();
                if (numbers.get(i) == 0) {
                    gc.setLineWidth(1.0);
                    lastX = lastX + 13.5 + 20;
                    gc.setFont(new Font(20));
                    gc.strokeText(String.valueOf(numbers.get(i)), lastX - 32, 300);
                    gc.closePath();
                } else {
                    gc.setLineWidth(numbers.get(i) * 15);
                    gc.fillRect(lastX,0,  lastX + numbers.get(i) * 1.5, 260);

                    gc.moveTo(lastX, 0);
                    gc.lineTo(lastX, 260 - numbers.get(i) - 6 *numbers.get(i));
                    gc.setLineWidth(1.0);
                    gc.setFont(new Font(20));
                    lastX = lastX + 1.5;
                    gc.strokeText(String.valueOf(numbers.get(i)), lastX  - 32, 300 );
                    lastX = lastX + 20;
                    gc.closePath();
                }*/

            }
        /*for(int i = 1; i < numbers.stream().count(); i++){
            gc.beginPath();
            gc.moveTo(lastX, 260);
            gc.fillText(String.valueOf(i), lastX, 260, 10);
            gc.setFont(Font.font(24));
            lastX = numbers.get(i) * 15 + 20;
            gc.stroke();
            gc.closePath();

        }*/

    }
}
