package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Producto;

public class MementoProducto {
    private Producto estado;

    public MementoProducto(Producto estado) {
        this.estado = estado;
    }

    public Producto getEstado() {
        return estado;
    }
}
