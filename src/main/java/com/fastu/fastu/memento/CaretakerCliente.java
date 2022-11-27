package com.fastu.fastu.memento;

import java.util.ArrayList;

public class CaretakerCliente {
    private ArrayList<MementoCliente> mementos = new ArrayList<>();

    public void addMemento(MementoCliente m) {
        mementos.add(m);
    }

    public MementoCliente getMemento(int index) {
        return mementos.get(index);
    }
}