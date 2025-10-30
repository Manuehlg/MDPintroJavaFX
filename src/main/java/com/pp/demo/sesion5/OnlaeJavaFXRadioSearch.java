package com.pp.demo.sesion5;

import com.pp.demo.sesion5.onlae.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo simple: búsqueda con RadioButtons y BorderPane
 * 
 * Componentes:
 * - RadioButton: para elegir entre buscar sorteo o usuario
 * - TextField: para escribir fecha o DNI
 * - Button: para buscar
 * - Label: para mostrar resultados
 * 
 * Layout: BorderPane (TOP: título, CENTER: formulario, BOTTOM: resultados)
 */
public class OnlaeJavaFXRadioSearch extends Application {

    private Onlae onlae;
    private RadioButton rbSorteo;
    private RadioButton rbUsuario;
    private TextField txtEntrada;
    private Label lblResultado;

    @Override
    public void start(Stage stage) {
        // 1. INICIALIZAR DATOS
        onlae = new Onlae();
        onlae.crearDatosEjemplo();

        // 2. CREAR LAYOUT PRINCIPAL: BorderPane
        BorderPane root = new BorderPane();

        // 3. REGIÓN TOP - Con VBox y Label
        VBox arriba = new VBox();
        root.setTop(arriba);
        Label texto1 = new Label();

        // 4. REGIÓN CENTER - Formulario de búsqueda
        VBox centro = new VBox();
        root.setCenter(centro);

        // Creamos el VBox y lo fijamos en el centro del BorderPane

        // RadioButtons para elegir tipo de búsqueda
        rbSorteo = new RadioButton("Buscar Sorteo");
        rbUsuario = new RadioButton("Buscar Usuario");
        ToggleGroup grupo = new ToggleGroup();
        rbSorteo.setToggleGroup(grupo);
        rbUsuario.setToggleGroup(grupo);
        rbSorteo.setSelected(true); // Por defecto buscar sorteo

        // Campo de entrada. Etiqueta y TextField

        // Botón buscar
        Button btnBuscar = new Button("Buscar");

        centro.getChildren().addAll(rbSorteo, rbUsuario, btnBuscar);
        // Se añaden los componentes al VBox central

        // 5. REGIÓN BOTTOM. VBox con la etiqueta de Resultados
        VBox abajo = new VBox();
        root.setBottom(arriba);
        Label texto2 = new Label();
        // 6. CONFIGURAR EVENTOS

        // Cuando se cambia el RadioButton, actualizar la etiqueta
        grupo.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {

            if (rbSorteo.isSelected()) {
                //Actualizar la etiqueta a "Buscar Sorteo"
                texto1.setText("Buscar Sorteo");
            } else {
                //Cambiar la etiqueta a "Buscar Usuario"
            }
            lblResultado.setText("");   // Limpiar resultados
            txtEntrada.clear();         // Limpiar campo de entrada

        });

        // Cuando se pulsa buscar
        btnBuscar.setOnAction(e -> {
            e.consume();
            if (rbSorteo.isSelected()) {    //Si está seleccionado buscar sorteo
                buscarSorteo();
            } else {
                buscarUsuario();    //Si está seleccionado buscar usuario
            }
        });

        
        // 7. CREAR Y MOSTRAR LA ESCENA
        Scene scene = new Scene(root, 600, 450);
        stage.setTitle("ONLAE - Búsqueda con RadioButtons");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Busca un sorteo por fecha
     */
    private void buscarSorteo() {
        // Obtener texto del TextField
        // Convertir a LocalDate con manejo de excepción
        // Buscar sorteo y mostrar resultados en lblResultado
    }

    /**
     * Busca un usuario por DNI
     */
    private void buscarUsuario() {        
        // Obtener texto del TextField
        // Buscar usuario y mostrar resultados en lblResultado
    }

    public static void main(String[] args) {
        launch(args);
    }
}
