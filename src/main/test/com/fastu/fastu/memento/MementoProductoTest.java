package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MementoProductoTest {

    private final Producto estado = new Producto("arroz", 2000, "arozz :)", null);

    @Test
    public void pruebaMementoP(MementoProducto m) {
        m = new MementoProducto(estado);

        Producto estado2 = m.getEstado();

        assertEquals(estado2, estado);
    }
}
