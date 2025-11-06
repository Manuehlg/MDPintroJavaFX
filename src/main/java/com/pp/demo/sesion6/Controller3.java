package com.pp.demo.sesion6;

import com.pp.demo.sesion6.boleto.Boleto;
import com.pp.demo.sesion6.onlae.Onlae;
import com.pp.demo.sesion6.onlae.Sorteo;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller3 {

    private Onlae onlae;

    @FXML
    private TableColumn<Boleto, String> colFecha;

    @FXML
    private TableColumn<Boleto, Integer> colId;

    @FXML
    private TableColumn<Boleto, String> colJugado;

    @FXML
    private TableColumn<Boleto, String> colNumeros;

    @FXML
    private TableColumn<Boleto, Double> colPrecio;

    @FXML
    private ListView<Sorteo> listSorteos;

    @FXML
    private TableView<Boleto> tableBoletos;

    @FXML
    public void initialize() {
        onlae = new Onlae();
        onlae.crearDatosEjemplo();
        cargarSorteos();
        configurarTabla();
        actualizarBoletos(listSorteos.getSelectionModel().getSelectedItem());
    }

    private void cargarSorteos() {
        listSorteos.getItems().addAll(onlae.getSorteos());
    }

    private void configurarTabla() {
        // Columna ID - usa PropertyValueFactory porque "identificador" es un campo simple
        colId.setCellValueFactory(new PropertyValueFactory<>("identificador"));
        // Columna Fecha - campo simple String
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        // Columna Números - es una List<Integer>, necesita ReadOnlyObjectWrapper
        colNumeros.setCellValueFactory(data ->
                new ReadOnlyObjectWrapper<>(data.getValue().getNumeros().toString())
        );
        // Columna Premio - campo simple Double
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("premio"));
        // Columna Jugado - es boolean, convertimos a "Sí"/"No"
        colJugado.setCellValueFactory(data ->
                new ReadOnlyObjectWrapper<>(data.getValue().isJugado() ? "Sí" : "No")
        );
    }

    private void actualizarBoletos (Sorteo s){
        tableBoletos.getItems().clear();
        tableBoletos.getItems().addAll(s.getBoletos());
    }
}
