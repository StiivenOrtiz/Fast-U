package com.fastu.fastu.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Clase para controlar la pantalla inicial
 */
public class IniciarController implements Controller {
    Stage stage;
    @FXML
    private Button botonIniciarSesion;
    @FXML
    private Button botonRegistrar;

    /**
     * Establece un setter para recibir un nuevo scenario
     *
     * @param stage
     */
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * para el boton "iniciar sesion" cambia de pantalla a iniciar sesion
     *
     * @param event
     */
    @FXML
    void ClickIniciarSesion(ActionEvent event) {
        Controller.cargarPantalla("IniciarSesion", this.stage);
    }

    /**
     * para el boton "registrar" cambia de pantalla a registro
     *
     * @param event
     */
    @FXML
    void ClickRegistrar(ActionEvent event) {
        Controller.cargarPantalla("Registro", this.stage);
    }

}
