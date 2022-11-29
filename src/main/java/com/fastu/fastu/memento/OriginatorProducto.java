package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Producto;

/**
 * (ENTER)
 * <p>
 * Clase encargada de guardar la informacion del objeto estado
 */

public class OriginatorProducto {

    private static Producto estado;

    /**
     * (ENTER)
     * <p>
     * crea una instancia de mementoProducto con el estado que vamos a guardar
     *
     * @return MementoProducto(estado)
     */

    public static MementoProducto guardar() {
        return new MementoProducto(estado);
    }

    /**
     * (ENTER)
     * <p>
     * regresa el estdo de un Producto
     *
     * @return estado
     */

    public Producto getEstado() {
        return estado;
    }

    /**
     * (ENTER)
     * <p>
     * establece el estado de cliente en el objeto Producto
     *
     * @param estado
     */

    public void setEstado(Producto estado) {
        OriginatorProducto.estado = estado;
    }

    /**(ENTER)
     *
     * restaura el estado del objeto m
     * @param m
     *
     */

    /*public void restaurar(Producto m) {
        this.estado = m.getEstado();
    }*/
}
