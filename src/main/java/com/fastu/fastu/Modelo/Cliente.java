package com.fastu.fastu.Modelo;

import java.util.ArrayList;

public class Cliente extends Datos {

    private ArrayList<Pedido> Pedidos;

    public Cliente(String nombresCompletos, String correo, String contrasena, ArrayList<Pedido> pedidos) {
        super(nombresCompletos, correo, contrasena);
        this.Pedidos = pedidos;
    }

    public Cliente(String nombresCompletos, String correo, String contrasena) {
        super(nombresCompletos, correo, contrasena);
    }

    public ArrayList<Pedido> getPedidos() {
        return Pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        Pedidos = pedidos;
    }
}
