package com.fastu.fastu.Fachada;

import com.fastu.fastu.Controladores.RegistroController;
import com.fastu.fastu.Modelo.Pedido;
import com.fastu.fastu.fachada.HistorialFachada;
import com.fastu.fastu.fachada.RealizarPedidoFachada;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealizarPedidoFachadaTest {
    @Test
    void testRealizarPedido() {
        RegistroController registroController = new RegistroController();
        RealizarPedidoFachada realizarPedido = new RealizarPedidoFachada();
        HistorialFachada lecturaHistorial = new HistorialFachada();
        registroController.setCorreo("prueba@javeriana.com");
        realizarPedido.registrarPedido();
        ArrayList<Pedido> pedidos = null;
        try {
            pedidos = lecturaHistorial.consultarHistorialPorCorreo("prueba@javeriana.com");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals("prueba@javeriana.com", pedidos.get(0).getCorreoSolicitante());
    }
}
