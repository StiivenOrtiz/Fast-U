package com.fastu.fastu.Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductoTest {

    @Test
    void getAndSetDescripcion() {
        String nombre = "nombre";
        float precio = 4.0F;
        String descripcion = "descripcion";
        String imagen = "imagen";
        Producto p = new Producto(nombre, precio, "", imagen);
        p.setDescripcion(descripcion);
        assertEquals(p.getDescripcion(), descripcion);
    }

    @Test
    void getAndSetImagen() {
        String nombre = "nombre";
        float precio = 4.0F;
        String descripcion = "descripcion";
        String imagen = "imagen";
        Producto p = new Producto(nombre, precio, descripcion, "");
        p.setImagenes(imagen);
        assertEquals(p.getImagen(), imagen);
    }

    @Test
    void getAndSetNombre() {
        String nombre = "nombre";
        float precio = 4.0F;
        String descripcion = "descripcion";
        String imagen = "imagen";

        Producto p = new Producto("", precio, descripcion, imagen);

        p.setNombre(nombre);
        assertEquals(p.getNombre(), nombre);
    }

    @Test
    void getAndSetPrecio() {
        String nombre = "nombre";
        float precio = 4.0F;
        String descripcion = "descripcion";
        String imagen = "imagen";

        Producto p = new Producto(nombre, 0.0F, descripcion, imagen);

        p.setPrecio(precio);
        assertEquals(p.getPrecio(), precio);
    }
}