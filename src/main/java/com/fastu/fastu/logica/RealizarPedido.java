package com.fastu.fastu.logica;

import com.fastu.fastu.Controladores.HistorialController;
import com.fastu.fastu.Controladores.RegistroController;
import com.fastu.fastu.Modelo.Pedido;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Clase para el proceso de la realización y registro del pedido
 */
public class RealizarPedido {
    /**
     * Función para crear y registrar el pedido en el historial
     */
    public void registrarPedido() {
        String[] metodosPago = {"Efectivio", "Tarjeta"};
        String met = metodosPago[1];
        int m = (int) Math.floor(Math.random() * 5);
        String estado;
        // 0 -> No realizado, 1 -> En preparación, 2 -> En trayecto, 3 -> Cancelado // 4 -> Entregado
        switch (m) {
            case 1:
                estado = "En preparación";
                break;
            case 2:
                estado = "En trayecto";
                break;
            case 3:
                estado = "Cancelado";
                break;
            case 4:
                estado = "Entregado";
                break;
            default:
                estado = "No realizado";
                break;
        }
        RegistroController registro = new RegistroController();
        String fecha = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        Pedido ped = new Pedido(fecha, met, estado, registro.getCorreo());
        HistorialController historialController = new HistorialController();
        historialController.agregarEnHistorial(ped);
    }
}
