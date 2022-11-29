package com.fastu.fastu.Modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DomiciliarioTest {

    @Test
    void getAndSetPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        pedidos.add(new Pedido("09/09/2022", "Tarjeta", "Activo"));
        Domiciliario d = new Domiciliario("Nombre", "Correo", "Contra", false, new ArrayList<Pedido>());
        d.setPedidos(pedidos);
        assertEquals(d.getPedidos(), pedidos);
    }

    @Test
    void getAndSetEstado() {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        Domiciliario d = new Domiciliario("Nombre", "Correo", "Contra", false, new ArrayList<Pedido>());
        d.setEstado(true);
        assertTrue(d.getEstado());
    }
}