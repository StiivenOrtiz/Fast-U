package com.fastu.fastu.Modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TiendaTest {

    @Test
    void getAndSetDueno() {
        String nombreCompleto = "nombreCompleto";
        String correo = "correo";
        String contrasena = "contrasena";
        String dueno = "dueno";
        String nombreTienda = "nombreTienda";
        String imagenTienda = "imagenTienda";
        String tipoTienda = "tipoTienda";
        Tienda t = new Tienda(nombreCompleto, correo, contrasena, "", nombreTienda, imagenTienda, tipoTienda);
        t.setDueno(dueno);
        assertEquals(t.getDueno(), dueno);
    }

    @Test
    void getAndSetNombreTienda() {
        String nombreCompleto = "nombreCompleto";
        String correo = "correo";
        String contrasena = "contrasena";
        String dueno = "dueno";
        String nombreTienda = "nombreTienda";
        String imagenTienda = "imagenTienda";
        String tipoTienda = "tipoTienda";
        Tienda t = new Tienda(nombreCompleto, correo, contrasena, dueno, "", imagenTienda, tipoTienda);
        t.setNombreTienda(nombreTienda);
        assertEquals(t.getNombreTienda(), nombreTienda);
    }

    @Test
    void getAndSetCalificacion() {
        String nombreCompleto = "nombreCompleto";
        String correo = "correo";
        String contrasena = "contrasena";
        String dueno = "dueno";
        String nombreTienda = "nombreTienda";
        String imagenTienda = "imagenTienda";
        String tipoTienda = "tipoTienda";
        float calificacion = 4.0F;
        Tienda t = new Tienda(nombreCompleto, correo, contrasena, dueno, nombreTienda, imagenTienda, tipoTienda);
        t.setCalificacion(calificacion);
        assertEquals(t.getCalificacion(), calificacion);
    }

    @Test
    void getAndSetProductos() {
        String nombreCompleto = "nombreCompleto";
        String correo = "correo";
        String contrasena = "contrasena";
        String dueno = "dueno";
        String nombreTienda = "nombreTienda";
        String imagenTienda = "imagenTienda";
        String tipoTienda = "tipoTienda";
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("nombre", 4.0F, "descripcion", "imagen"));
        Tienda t = new Tienda(nombreCompleto, correo, contrasena, dueno, nombreTienda, imagenTienda, tipoTienda);
        t.setProductos(productos);
        assertEquals(t.getProductos(), productos);
    }

    @Test
    void getAndSetTiempoEntrega() {
        String nombreCompleto = "nombreCompleto";
        String correo = "correo";
        String contrasena = "contrasena";
        String dueno = "dueno";
        String nombreTienda = "nombreTienda";
        String imagenTienda = "imagenTienda";
        String tipoTienda = "tipoTienda";
        float tiempoEntrega = 4.0F;
        Tienda t = new Tienda(nombreCompleto, correo, contrasena, dueno, nombreTienda, imagenTienda, tipoTienda);
        t.setTiempoEntrega(tiempoEntrega);
        assertEquals(t.getTiempoEntrega(), tiempoEntrega);
    }

    @Test
    void getAndSetCostoEnvio() {
        String nombreCompleto = "nombreCompleto";
        String correo = "correo";
        String contrasena = "contrasena";
        String dueno = "dueno";
        String nombreTienda = "nombreTienda";
        String imagenTienda = "imagenTienda";
        String tipoTienda = "tipoTienda";
        float costoEnvio = 4.0F;
        Tienda t = new Tienda(nombreCompleto, correo, contrasena, dueno, nombreTienda, imagenTienda, tipoTienda);
        t.setCostoEnvio(costoEnvio);
        assertEquals(t.getCostoEnvio(), costoEnvio);
    }

    @Test
    void getAndSetImagenTienda() {
        String nombreCompleto = "nombreCompleto";
        String correo = "correo";
        String contrasena = "contrasena";
        String dueno = "dueno";
        String nombreTienda = "nombreTienda";
        String imagenTienda = "imagenTienda";
        String tipoTienda = "tipoTienda";
        Tienda t = new Tienda(nombreCompleto, correo, contrasena, dueno, nombreTienda, "", tipoTienda);
        t.setImagenTienda(imagenTienda);
        assertEquals(t.getImagenTienda(), imagenTienda);
    }

    @Test
    void getAndSetTipoTienda() {
        String nombreCompleto = "nombreCompleto";
        String correo = "correo";
        String contrasena = "contrasena";
        String dueno = "dueno";
        String nombreTienda = "nombreTienda";
        String imagenTienda = "imagenTienda";
        String tipoTienda = "tipoTienda";
        Tienda t = new Tienda(nombreCompleto, correo, contrasena, dueno, nombreTienda, imagenTienda, "");
        t.setTipoTienda(tipoTienda);
        assertEquals(t.getTipoTienda(), tipoTienda);
    }
}