package com.fastu.fastu.persistencia;

import com.fastu.fastu.Modelo.Pedido;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EscrituraHistorialTest {
    @Test
    void testActualizarLecturaHistorial() {
        LecturaHistorial lecturaHistorial = new LecturaHistorial();
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        ArrayList<Pedido> peds;
        ArrayList<Pedido> pedsNuevo;
        try {
            escrituraHistorial.agregarHistorial("27/11/2022", "Efectivo", "Cancelado", "test@javeriana.com");
            peds = lecturaHistorial.leerHistorialPedidos("test@javeriana.com");
            pedsNuevo = escrituraHistorial.actualizarArrayPedidos(peds, "test@javeriana.com", "testN@javeriana.com");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals("testN@javeriana.com", pedsNuevo.get(0).getCorreoSolicitante());
    }
}