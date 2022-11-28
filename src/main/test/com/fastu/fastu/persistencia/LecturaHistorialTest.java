package com.fastu.fastu.persistencia;

import com.fastu.fastu.Modelo.Pedido;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

class LecturaHistorialTest {
    @Test
    void testLecturaHistorial() {
        LecturaHistorial lecturaHistorial = new LecturaHistorial();
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        Pedido ped = new Pedido("27/08/2022", "Efectivo", "Cancelado", "test@test.com");
        ArrayList<Pedido> pedidos = new ArrayList<>();
        ArrayList<Pedido> pedidosEsperados = new ArrayList<>();
        pedidos.clear();
        pedidosEsperados.clear();
        pedidosEsperados.add(ped);
        try {
            escrituraHistorial.agregarHistorial("27/08/2022", "Efectivo", "Cancelado", "test@test.com");
            pedidos = lecturaHistorial.leerHistorialPedidos("test@test.com");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(pedidosEsperados.get(0).getCorreoSolicitante(), pedidos.get(0).getCorreoSolicitante() );
    }

}