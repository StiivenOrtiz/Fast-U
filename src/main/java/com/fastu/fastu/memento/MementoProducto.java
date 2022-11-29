package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Producto;

/**
 * (ENTER)
 * <p>
 * guarda el estado actual del objeto producto basado en el estado de originatorProducto
 */

public class MementoProducto {
    private final Producto estado;

    /**
     * (ENTER)
     * <p>
     * guarda el estado actual del objeto producto en un estado
     *
     * @param estado
     */

    public MementoProducto(Producto estado) {
        this.estado = estado;
    }

    /**
     * (ENTER)
     * <p>
     * obtiene el objeto estado
     *
     * @return estado
     */

    public Producto getEstado() {
        return estado;
    }
}
