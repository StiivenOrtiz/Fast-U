package com.fastu.fastu.memento;

import java.util.ArrayList;

public class CaretakerProducto {
    private ArrayList<MementoProducto> mementos = new ArrayList<>();

    public void addMemento(MementoProducto m) {
        mementos.add(m);
    }

    public MementoProducto getMemento(int index) {
        return mementos.get(index);
    }
}