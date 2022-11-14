package interfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        URL urlAppScene = getClass().getResource("AppScene.fxml");
        Parent root = FXMLLoader.load(urlAppScene);

        Scene scene = new Scene(root);

        stage.setHeight(540);
        stage.setWidth(720);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("App");
        stage.show();
    }
}