package com.fastu.fastu.memento;

import java.util.ArrayList;

/**(ENTER)
 *
 * Almacena los estados del un cliente en una lista de estados de clientes
 *
 */

public class CaretakerCliente {
    private final ArrayList<MementoCliente> mementos = new ArrayList<>();

    /**(ENTER)
     *
     * agrega un elemento de memento cliente a la lista
     * @Param m
     *
     */

    public void addMemento(MementoCliente m) {
        mementos.add(m);
    }

    /**(ENTER)
     *
     * obtiene un elemento de la lista de MementoCliente
     * @Param m
     * @return indice para la lista de memento
     */

    public MementoCliente getMemento(int index) {
        return mementos.get(index);
    }
}