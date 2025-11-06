package com.pp.demo.sesion6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = FXMLLoader.load((getClass().getResource("vista3.fxml"))); //Ponemos el fichero fxml creado
            Scene scene = new Scene(root, 400, 400);

                //scene.getStylesheets().add(getClass().
                //getResource("application.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
