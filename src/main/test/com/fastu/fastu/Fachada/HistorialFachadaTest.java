package com.fastu.fastu.Fachada;

import com.fastu.fastu.Modelo.Pedido;
import com.fastu.fastu.fachada.HistorialFachada;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistorialFachadaTest {
    @Test
    void testActualizarHistorial() {
        HistorialFachada lecturaHistorial = new HistorialFachada();
        HistorialFachada escrituraHistorial = new HistorialFachada();
        ArrayList<Pedido> peds;
        ArrayList<Pedido> pedsNuevo;
        try {
            escrituraHistorial.adicionarRegistroHistorial("27/11/2022", "Efectivo", "Cancelado", "test@javeriana.com");
            peds = lecturaHistorial.consultarHistorialPorCorreo("test@javeriana.com");
            pedsNuevo = escrituraHistorial.actualizarArrayPedidos(peds, "test@javeriana.com", "testN@javeriana.com");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals("testN@javeriana.com", pedsNuevo.get(0).getCorreoSolicitante());
    }

}
