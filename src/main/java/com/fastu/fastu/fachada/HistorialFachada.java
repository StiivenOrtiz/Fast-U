package com.fastu.fastu.fachada;

import com.fastu.fastu.Modelo.Pedido;
import com.fastu.fastu.persistencia.EscrituraHistorial;
import com.fastu.fastu.persistencia.LecturaHistorial;

import java.io.IOException;
import java.util.ArrayList;

public class HistorialFachada {
    public ArrayList<Pedido> consultarHistorialPorCorreo(String correo) throws IOException {
        LecturaHistorial lecturaHistorial = new LecturaHistorial();
        return lecturaHistorial.leerHistorialPedidos(correo);
    }

    public void adicionarRegistroHistorial(String fecha, String tipoPago, String estado, String correoSolicitante) throws IOException {
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        escrituraHistorial.agregarHistorial(fecha, tipoPago, estado, correoSolicitante);
    }

    public void guardarNuevoHistorial(ArrayList<Pedido> pedidos, String correon) {
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        escrituraHistorial.guardarNuevoHistorial(pedidos, correon);
    }

    public void guardarHistorial(ArrayList<Pedido> pedidos) {
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        escrituraHistorial.guardarHistorial(pedidos);
    }

    public ArrayList<Pedido> cargarHistorial() throws IOException {
        LecturaHistorial lecturaHistorial = new LecturaHistorial();
        return lecturaHistorial.cargarHistorial();
    }

    public ArrayList<Pedido> actualizarArrayPedidos(ArrayList<Pedido> pedidos, String correoa, String correon) {
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        return escrituraHistorial.actualizarArrayPedidos(pedidos, correoa, correon);
    }
}