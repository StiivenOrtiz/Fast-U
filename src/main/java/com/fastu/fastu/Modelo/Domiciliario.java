package com.fastu.fastu.Modelo;

import java.util.ArrayList;

public class Domiciliario extends Datos {
    private boolean estado;
    private ArrayList<Pedido> pedidos;

    Domiciliario(String nombresCompletos, String correo, String contrasena, boolean estado, ArrayList<Pedido> pedidos) {
        super(nombresCompletos, correo, contrasena);
        this.estado = estado;
        this.pedidos = pedidos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
