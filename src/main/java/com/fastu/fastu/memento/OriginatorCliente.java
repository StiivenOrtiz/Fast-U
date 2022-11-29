package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Cliente;

/**
 * (ENTER)
 * <p>
 * Clase encargada de guardar la informacion del objeto estado
 */

public class OriginatorCliente {

    private Cliente estado;

    /**
     * (ENTER)
     * <p>
     * regresa el estdo de un cliente
     *
     * @return estado
     */

    public Cliente getEstado() {
        return estado;
    }

    /**
     * (ENTER)
     * <p>
     * establece el estado de cliente en el objeto cliente
     *
     * @param estado
     */

    public void setEstado(Cliente estado) {
        this.estado = estado;
    }

    /**
     * (ENTER)
     * <p>
     * crea una instancia de mementoCliente con el estado que vamos a guardar
     *
     * @return MementoCliente(estado)
     */

    public MementoCliente guardar() {
        return new MementoCliente(estado);
    }

    /**
     * (ENTER)
     * <p>
     * restaura el estado del objeto m
     *
     * @param m
     */

    public void restaurar(MementoCliente m) {
        this.estado = m.getEstado();
    }
}
