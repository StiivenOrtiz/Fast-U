package com.fastu.fastu.fachada;

import com.fastu.fastu.Modelo.Pedido;
import com.fastu.fastu.persistencia.EscrituraHistorial;
import com.fastu.fastu.persistencia.LecturaHistorial;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase de Fachada para el manejo del historial
 **/
public class HistorialFachada {
    /**
     * Consulta el historial de la persona por el correo registrado
     *
     * @param correo
     * @return ArrayList<Pedido> con todos los pedidos que tienen el correo recibido como parametro
     * @throws IOException
     */
    public ArrayList<Pedido> consultarHistorialPorCorreo(String correo) throws IOException {
        LecturaHistorial lecturaHistorial = new LecturaHistorial();
        return lecturaHistorial.leerHistorialPedidos(correo);
    }

    /**
     * Adiciona un nuevo registro al archivo del texto del historial con los parametros recibidos
     *
     * @param fecha
     * @param tipoPago
     * @param estado
     * @param correoSolicitante
     * @throws IOException
     */
    public void adicionarRegistroHistorial(String fecha, String tipoPago, String estado, String correoSolicitante) throws IOException {
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        escrituraHistorial.agregarHistorial(fecha, tipoPago, estado, correoSolicitante);
    }

    /**
     * Guarda el nuevo historial con el correo nuevo en el archivo txt
     *
     * @param pedidos
     * @param correon
     */
    public void guardarNuevoHistorial(ArrayList<Pedido> pedidos, String correon) {
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        escrituraHistorial.guardarNuevoHistorial(pedidos, correon);
    }

    /**
     * Guarda el historial en el archivo txt
     *
     * @param pedidos
     */
    public void guardarHistorial(ArrayList<Pedido> pedidos) {
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        escrituraHistorial.guardarHistorial(pedidos);
    }

    /**
     * Carga el historial leido en un ArrayList de Pedidos
     *
     * @return ArrayList<Pedido> con los pedidos leidos
     * @throws IOException
     */
    public ArrayList<Pedido> cargarHistorial() throws IOException {
        LecturaHistorial lecturaHistorial = new LecturaHistorial();
        return lecturaHistorial.cargarHistorial();
    }

    /**
     * Actualiza el ArrayList de pedidos con el correo nuevo
     *
     * @param pedidos
     * @param correoa
     * @param correon
     * @return ArrayList<Pedido> con el correo nuevo
     */
    public ArrayList<Pedido> actualizarArrayPedidos(ArrayList<Pedido> pedidos, String correoa, String correon) {
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        return escrituraHistorial.actualizarArrayPedidos(pedidos, correoa, correon);
    }
}