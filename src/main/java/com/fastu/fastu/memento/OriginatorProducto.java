package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Producto;

public class OriginatorProducto {

    private static Producto estado;

    public void setEstado(Producto estado) {
        this.estado = estado;
    }

    public Producto getEstado() {
        return estado;
    }

    public static MementoProducto guardar() {
        return new MementoProducto(estado);
    }

    public void restaurar(MementoProducto m) {
        this.estado = m.getEstado();
    }
}
