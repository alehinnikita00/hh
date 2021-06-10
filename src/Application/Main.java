package Application;

import View.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application implements Runnable {

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        View view = new View();
        view.changeStage("laborant.fxml");
        primaryStage = view.getStage();
        primaryStage.show();
    }
    public void run(){

    }



    public static void main(String[] args) {
        launch(args);
    }
}
