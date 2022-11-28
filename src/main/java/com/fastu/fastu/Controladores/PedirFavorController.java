package com.fastu.fastu.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PedirFavorController implements Controller {
    Stage stage;
    @FXML
    private Label welcomeText;
    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check4;
    @FXML
    private TextField especificar;
    @FXML
    private Button botonDevolver;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }


    /**
     * para el boton devolver, cambia de pantalla al menu
     * @param event
     */
    @FXML
    void Devolverse(ActionEvent event) {
        Controller.cargarPantalla("Menu", this.stage);
    }

    /**
     * para el boton, cambia de pantalla a pago
     * @param event
     */
    @FXML
    void BotonRegistrar(ActionEvent event) {
        Controller.cargarPantalla("Pago", this.stage);
    }
}