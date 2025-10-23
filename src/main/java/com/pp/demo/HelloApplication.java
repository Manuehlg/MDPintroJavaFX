package com.pp.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        Button b = new Button("Prueba");

        // añade el componente al contenedor
        root.getChildren().add(b);

        b.setText("Click me");
        b.setOnAction( new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                stage.setTitle("Nuevo Titulo");
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}