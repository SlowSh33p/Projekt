package Applikation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;


public class App extends Application{

    @Override
    public void start(Stage primaryStage){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("LadenFX.fxml"));
            Scene scene = new Scene(root);
            Image icon = new Image("Applikation/eis.jpg");
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("Eisladen");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }


}
