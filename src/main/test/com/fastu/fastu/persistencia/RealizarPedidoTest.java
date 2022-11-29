package com.fastu.fastu.persistencia;

import com.fastu.fastu.Controladores.RegistroController;
import com.fastu.fastu.Modelo.Pedido;
import com.fastu.fastu.logica.RealizarPedido;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealizarPedidoTest {
    @Test
    void testRealizarPedido() {
        RegistroController registroController = new RegistroController();
        RealizarPedido realizarPedido = new RealizarPedido();
        LecturaHistorial lecturaHistorial = new LecturaHistorial();
        registroController.setCorreo("prueba@javeriana.com");
        realizarPedido.registrarPedido();
        ArrayList<Pedido> pedidos = null;
        try {
            pedidos = lecturaHistorial.leerHistorialPedidos("prueba@javeriana.com");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals("prueba@javeriana.com", pedidos.get(0).getCorreoSolicitante());
    }
}
