package com.fastu.fastu.Controladores;

import javafx.stage.Stage;

/**
 * Clase encargada de servir como un auxiliar al Controlador de Pago, puesto que este implementa ya una interfaz
 * para el funcionamiento de JavaFx
 */
public class ControllerAuxPago implements Controller {
    Stage stage;

    /**
     * Estable un setter para recibir un nuevo scenario
     *
     * @param stage
     */
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
