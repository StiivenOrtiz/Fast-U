package com.fastu.fastu.fachada;

import com.fastu.fastu.logica.RealizarPedido;

/**
 * Clase para fachada de manejo de de realizar y registrar pedidos
 */
public class RealizarPedidoFachada {
    /**
     * Registra el pedido en el archivo del historial
     */
    public void registrarPedido() {
        RealizarPedido realizarPedido = new RealizarPedido();
        realizarPedido.registrarPedido();
    }
}
