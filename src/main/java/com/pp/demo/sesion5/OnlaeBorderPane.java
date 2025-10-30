package com.pp.demo.sesion5;

import com.pp.demo.sesion5.onlae.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class OnlaeBorderPane extends Application {
    private Onlae onlae;
    @Override
    public void start(Stage stage) throws IOException {
        onlae = new Onlae();
        onlae.crearDatosEjemplo();
        // 2. CREAR EL LAYOUT PRINCIPAL: BorderPane
        BorderPane root = new BorderPane();
        // 2.1 TOP
        // Etiqueta inicial para el usuario donde se muestre "Escribe el nombre del sorteo:"
        Label etiqueta = new Label("Introduce el nombre del sorteo:");



        // /Fijarla al top
        root.setTop(etiqueta);
        // 2.2 CENTER
        // Primero crear un panel VBox para el centro
        VBox center = new VBox();
        root.setCenter(center);
        // Crear un Cuadro de texto para escribir el nombre del sorteo y añadirlo al VBox
        TextField textito = new TextField();

        // Crear el botón Botón para buscar y añadirlo al VBox
        Button busqueda= new Button ("Buscar");
        center.getChildren().addAll(textito,busqueda);
        // 2.3 BOTTOM

        // Etiqueta para mostrar el resultado
        Label etiquetafinal = new Label();
        root.setBottom(etiquetafinal);
        // 3. CONFIGURAR LA ACCIÓN DEL BOTÓN

        busqueda.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int entrada = Integer.parseInt(textito.getText());

                for (Sorteo s : onlae.getSorteos()){
                    if (s.getId() == entrada){
                        etiquetafinal.setText(s.getFecha().toString());
                    }
                }
            }
        });

        // 4. CREAR Y MOSTRAR LA ESCENA
        Scene scene = new Scene(root, 500, 400);
        stage.setTitle("Sistema ONLAE - Ejemplo Simple JavaFX");
        stage.setScene(scene);
        stage.show();

    }
        public static void main (String[]args){
            launch();
        }
    }