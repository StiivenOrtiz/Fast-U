package com.fastu.fastu.memento;

import java.util.ArrayList;

/**
 * (ENTER)
 * <p>
 * Almacena los estados del un cliente en una lista de estados de clientes
 */

public class CaretakerCliente {
    private final ArrayList<MementoCliente> mementos = new ArrayList<>();

    /**
     * (ENTER)
     * <p>
     * agrega un elemento de memento cliente a la lista
     *
     * @Param m
     */

    public void addMemento(MementoCliente m) {
        mementos.add(m);
    }

    /**
     * (ENTER)
     * <p>
     * obtiene un elemento de la lista de MementoCliente
     *
     * @return indice para la lista de memento
     * @Param m
     */

    public MementoCliente getMemento(int index) {
        return mementos.get(index);
    }
}