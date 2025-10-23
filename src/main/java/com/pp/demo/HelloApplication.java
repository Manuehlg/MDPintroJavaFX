package com.pp.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        //fijo el layouu
        HBox arriba = new HBox();
        root.setTop(arriba);
        VBox abajo = new VBox();
        root.setBottom(abajo);
        HBox medio = new HBox();
        root.setCenter(medio);
        medio.setAlignment(Pos.CENTER);


        TextField t = new TextField();
        t.setText("te estoy hablandoooo");
        medio.getChildren().add(t);

        RadioButton botonraro = new RadioButton ("seleccioname");
        Button b = new Button("Prueba");
        Button b2 = new Button("Prueba2");
        Button b3 = new Button("Prueba3");
        // añade el componente al contenedor
        arriba.getChildren().add(b);
        abajo.getChildren().add(b2);
        medio.getChildren().add(botonraro);
        medio.getChildren().add(b3);

        b.setOnAction( new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                stage.setTitle("Nuevo Titulo");
            }
        });
        b3.setOnAction( new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                t.setText("me han cambiadoooo");
            }
        });
        b2.setOnAction( new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                try{
                if ( Integer.parseInt(t.getText()) %2 == 0){
                    t.setText("es par");
                }
                else if ( Integer.parseInt(t.getText()) %2 !=0){
                    t.setText("es impar");
                }}
                catch (Exception e){
                    t.setText("mete un numero chuleta?");
                }
            }
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}