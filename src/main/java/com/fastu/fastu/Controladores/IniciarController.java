package com.fastu.fastu.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IniciarController implements Controller {
    Stage stage;
    @FXML
    private Button botonIniciarSesion;
    @FXML
    private Button botonRegistrar;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void ClickIniciarSesion(ActionEvent event) {
        Controller.cargarPantalla("IniciarSesion", this.stage);
    }

    @FXML
    void ClickRegistrar(ActionEvent event) {
        Controller.cargarPantalla("Registro", this.stage);
    }

}
