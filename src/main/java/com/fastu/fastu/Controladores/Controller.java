package com.fastu.fastu.Controladores;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Interfaz de Controller la cual generealiza los controller.
 */
public interface Controller {

    /**
     * Función estática que todo controller puede hacer uso de ella
     *
     * @param nombrePantalla
     * @param stageActual
     */
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

    /**
     * Función necesaria para el cambio de pantallas.
     *
     * @param stage
     */
    void setStage(Stage stage);
}
