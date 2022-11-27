package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Cliente;

public class MementoCliente {
    private Cliente estado;

    public MementoCliente(Cliente estado) {
        this.estado = estado;
    }

    public Cliente getEstado() {
        return estado;
    }
}