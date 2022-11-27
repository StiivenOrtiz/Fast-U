package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Cliente;

public class OriginatorCliente {

    private Cliente estado;

    public void setEstado(Cliente estado) {
        this.estado = estado;
    }

    public Cliente getEstado() {
        return estado;
    }

    public MementoCliente guardar() {
        return new MementoCliente(estado);
    }

    public void restaurar(MementoCliente m) {
        this.estado = m.getEstado();
    }
}
