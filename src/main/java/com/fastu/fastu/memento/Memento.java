package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Cliente;

public class Memento {
    private Cliente estado;

    public Memento(Cliente estado) {
        this.estado = estado;
    }

    public Cliente getEstado() {
        return estado;
    }
}
