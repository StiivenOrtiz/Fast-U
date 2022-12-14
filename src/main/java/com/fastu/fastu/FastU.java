package com.fastu.fastu;

import com.fastu.fastu.Controladores.CargadorPantallas;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class FastU extends Application {
    public static void main(String[] args) {
        launch();
    }

    /**
     * Inicializa la aplicación FastU
     *
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     */
    @Override
    public void start(Stage stage) {
        String nombrePantalla = "Iniciar";
        try {
            CargadorPantallas.cargarPantalla(stage, nombrePantalla);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No se pudo cargar la pantalla: " + nombrePantalla);
            alert.setHeaderText("ERROR DE CARGADOR DE PANTALLAS");
            alert.show();
        }
    }
}