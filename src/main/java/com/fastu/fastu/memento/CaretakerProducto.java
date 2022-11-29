package com.fastu.fastu.memento;

import java.util.ArrayList;

/**
 * (ENTER)
 * <p>
 * Almacena los estados del un cliente en una lista de estados de productos
 */

public class CaretakerProducto {
    private final ArrayList<MementoProducto> mementos = new ArrayList<>();

    /**
     * (ENTER)
     * <p>
     * agrega un elemento de memento producto a la lista
     *
     * @Param m
     */

    public void addMemento(MementoProducto m) {
        mementos.add(m);
    }

    /**
     * (ENTER)
     * <p>
     * obtiene un elemento de la lista de mementoProducto
     *
     * @return indice para la lista de memento
     * @Param m
     */

    public MementoProducto getMemento(int index) {
        return mementos.get(index);
    }
}