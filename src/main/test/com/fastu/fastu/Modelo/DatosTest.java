package com.fastu.fastu.Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatosTest {

    @Test
    void getAndSetContrasena() {
        String valorPrueba = "123";
        Datos d = new Datos() {
        };
        d.setContrasena(valorPrueba);
        assertEquals(d.getContrasena(), valorPrueba);
    }

    @Test
    void getAndSetCorreo() {
        String valorPrueba = "123";
        Datos d = new Datos() {
        };
        d.setCorreo(valorPrueba);
        assertEquals(d.getCorreo(), valorPrueba);
    }

    @Test
    void getAndSetNombreCompletos() {
        String valorPrueba = "123";
        Datos d = new Datos() {
        };
        d.setNombreCompleto(valorPrueba);
        assertEquals(d.getNombreCompletos(), valorPrueba);
    }
}