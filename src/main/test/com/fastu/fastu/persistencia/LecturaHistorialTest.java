package com.fastu.fastu.persistencia;

import com.fastu.fastu.Modelo.Pedido;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LecturaHistorialTest {
    @Test
    void testLecturaHistorial() {
        LecturaHistorial lecturaHistorial = new LecturaHistorial();
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        Pedido ped = new Pedido("27/08/2022", "Efectivo", "Cancelado", "test@javeriana.edu.co");
        ArrayList<Pedido> pedidos = new ArrayList<>();
        ArrayList<Pedido> pedidosEsperados = new ArrayList<>();
        pedidosEsperados.add(ped);
        try {
            escrituraHistorial.agregarHistorial("27/08/2022", "Efectivo", "Cancelado", "test@javeriana.edu.co");
            pedidos = lecturaHistorial.leerHistorialPedidos("test@javeriana.edu.co");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(pedidosEsperados.get(0).getCorreoSolicitante(), pedidos.get(0).getCorreoSolicitante());
    }

}