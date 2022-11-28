package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Cliente;

/**(ENTER)
 *
 * guarda el estado actual del objeto cliente basado en el estado de originatorCliente
 *
 */

public class MementoCliente {
    private final Cliente estado;

    /**(ENTER)
     *
     * guarda el estado actual del objeto cliente en un estado
     * @param estado
     *
     */

    public MementoCliente(Cliente estado) {
        this.estado = estado;
    }

    /**(ENTER)
     *
     * obtiene el objeto estado
     * @return  estado
     *
     */

    public Cliente getEstado() {
        return estado;
    }
}