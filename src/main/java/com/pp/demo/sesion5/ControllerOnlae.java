package com.pp.demo.sesion5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerOnlae {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}