package com.fastu.fastu.Controladores;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public interface Controller {
    static void cargarPantalla(String nombrePantalla, Stage stageActual) {
        try {
            CargadorPantallas.cargarPantalla(stageActual, nombrePantalla);
            stageActual.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No se pudo cargar la pantalla: " + nombrePantalla);
            alert.setHeaderText("ERROR DE CARGADOR DE PANTALLAS");
            alert.show();
        }
    }

    void setStage(Stage stage);
}
