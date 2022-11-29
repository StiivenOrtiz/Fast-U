package com.fastu.fastu.Modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {

    @Test
    void getPedidos() {
        Cliente c = new Cliente();
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        pedidos.add(new Pedido("09/09/2022", "Tarjeta", "Activo"));
        c.setPedidos(pedidos);
        assertEquals(c.getPedidos(), pedidos);
    }

    @Test
    void setPedidos() {
        Cliente c = new Cliente();
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        c.setPedidos(pedidos);
        pedidos.add(new Pedido("09/09/2022", "Tarjeta", "Activo"));
        assertEquals(c.getPedidos(), pedidos);
    }
}