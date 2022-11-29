package com.fastu.fastu.Modelo;

import java.util.ArrayList;

public class Cliente extends Datos {

    private ArrayList<Pedido> Pedidos;

    /**
     * Constructor Cliente
     *
     * @param nombresCompletos
     * @param correo
     * @param contrasena
     * @param pedidos
     */
    public Cliente(String nombresCompletos, String correo, String contrasena, ArrayList<Pedido> pedidos) {
        super(nombresCompletos, correo, contrasena);
        this.Pedidos = pedidos;
    }

    /**
     * Constructor Cliente
     *
     * @param nombresCompletos
     * @param correo
     * @param contrasena
     */
    public Cliente(String nombresCompletos, String correo, String contrasena) {
        super(nombresCompletos, correo, contrasena);
    }

    /**
     * Constructor Cliente
     */
    public Cliente() {
        super();
    }

    /**
     * Getter que regresa arrayList de pedidos
     *
     * @return ArrayList<Pedido> con los pedidos del cliente
     */
    public ArrayList<Pedido> getPedidos() {
        return Pedidos;
    }

    /**
     * Recibe ArrayList con los pedidos del cliente
     *
     * @param pedidos
     */
    public void setPedidos(ArrayList<Pedido> pedidos) {
        Pedidos = pedidos;
    }
}
