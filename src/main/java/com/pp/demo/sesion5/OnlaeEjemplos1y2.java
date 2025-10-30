package com.pp.demo.sesion5;

import com.pp.demo.sesion5.onlae.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;

public class OnlaeEjemplos1y2 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HBox root = new HBox();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Probando Onlae con JavaFX!");
        stage.setScene(scene);


        Onlae onlae = new Onlae();
        onlae.crearDatosEjemplo();


        Label etiqueta = new Label("Introduce el nombre del sorteo:");
        root.getChildren().add(etiqueta);
        TextField textito = new TextField("Nombre del sorteo");
        root.getChildren().add(textito);
        Label etiquetafinal = new Label();

        Button b = new Button("Buscar sorteo");


        b.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int entrada = Integer.parseInt(textito.getText());

                for (Sorteo s : onlae.getSorteos()){
                    if (s.getId() == entrada){
                        etiquetafinal.setText(s.getFecha().toString());
                    }
                }
            }
        });
        root.getChildren().add(b);


        root.getChildren().add(etiquetafinal);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}