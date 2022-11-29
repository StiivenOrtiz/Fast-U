package com.fastu.fastu.Modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedidoTest {

    @Test
    void getAndSetCalificacion() {
        float f = 4.0F;
        Pedido p = new Pedido("09/09/2022", "Tarjeta", "Activo");
        p.setCalificacion(f);
        assertEquals(p.getCalificacion(), f);
    }

    @Test
    void getAndSetDomiciliario() {
        Pedido p = new Pedido("09/09/2022", "Tarjeta", "Activo");
        Datos datos = new Datos() {
        };
        datos.setNombreCompleto("TEST");
        p.setDomiciliario(datos);
        assertEquals(p.getDomiciliario(), datos);
    }

    @Test
    void getAndSetProductos() {
        Pedido p = new Pedido("09/09/2022", "Tarjeta", "Activo");
        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto("TEST", 4.0F, "TEST", "imagen"));
        p.setProductos(productos);
        assertEquals(p.getProductos(), productos);
    }

    @Test
    void getAndSetTienda() {
        Pedido p = new Pedido("09/09/2022", "Tarjeta", "Activo");
        String nombreTienda = "Tienda";
        p.setTienda(nombreTienda);
        assertEquals(p.getTienda(), nombreTienda);
    }

    @Test
    void getTipopago() {
        String tipoPago = "Tarjeta";
        Pedido p = new Pedido("09/09/2022", tipoPago, "Activo");
        assertEquals(p.getTipopago(), tipoPago);
    }

    @Test
    void getAndSetEstado() {
        String estado = "Nuevo";
        Pedido p = new Pedido("09/09/2022", "Tarjeta", estado);
        p.setEstado(estado);
        assertEquals(p.getEstado(), estado);
    }

    @Test
    void getAndSetFecha() {
        String fecha = "09/09/2022";
        Pedido p = new Pedido(fecha, "Tarjeta", "Activo");
        p.setFecha(fecha);
        assertEquals(p.getFecha(), fecha);
    }

    @Test
    void getAndSetCorreoSolicitante() {
        String correo = "CorreoSolicitante";
        Pedido p = new Pedido("09/09/2022", "Tarjeta", "Activo");
        p.setCorreoSolicitante(correo);
        assertEquals(p.getCorreoSolicitante(), correo);
    }
}