package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View {
    private String fxml;
    private Stage stage;

    public View(){}

    private void Init() throws  Exception{
        stage = new Stage();
        Pane pane = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }

    public Stage getStage() throws Exception{
        Init();
        return stage;
    }

    public void changeStage(String fxml) throws Exception{
        this.fxml = fxml;
        Init();
    }

    public void openStage(String fxml) throws Exception{
        Stage stage = new Stage();
        Pane pane = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


}
