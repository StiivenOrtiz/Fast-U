package com.fastu.fastu.Controladores;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CargadorPantallasTest {

    @Test
    void cargarPantalla() {
        String pantallaCargar = "Menu";
        Stage stage = null;
        boolean creado = true;
        try {
            CargadorPantallas.cargarPantalla(stage, pantallaCargar);
        } catch (IOException e) {
            System.out.println("EXEPCION");
            creado = false;
        }
        assertFalse(creado);
    }

    @Test
    void cargarTienda() {
        String tiendaSolicitada = "Papelería";
        boolean creado = true;
        try {
            CargadorPantallas.cargarTienda(tiendaSolicitada);
        } catch (IOException e) {
            System.out.println("EXEPCION");
            creado = false;
        }
        assertFalse(creado);
    }
}