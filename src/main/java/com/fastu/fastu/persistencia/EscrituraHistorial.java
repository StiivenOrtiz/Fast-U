package com.fastu.fastu.persistencia;

import com.fastu.fastu.Modelo.Pedido;
import com.fastu.fastu.Util.Constantes;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class EscrituraHistorial {

    /**
     * Agrega al txt el pedido realizado por un cliente en especifico
     *
     * @param fecha
     * @param tipoPago
     * @param estado
     * @param correoSolicitante
     * @throws IOException
     */
    public void agregarHistorial(String fecha, String tipoPago, String estado, String correoSolicitante) throws IOException {
        File archivo = new File(Constantes.nombreHistorial);
        if (archivo.exists()) {
            try {
                FileWriter escribir = new FileWriter(archivo, true);
                PrintWriter imprimir = new PrintWriter(escribir);
                imprimir.println(fecha + "," + tipoPago + "," + estado + "," + correoSolicitante);
                imprimir.close();
                escribir.close();
            } catch (IOException ex) {
                System.out.println("error al modificar el archivo historial.txt");
                ex.printStackTrace();
                throw ex;
            }
        } else {
            crearArchivoHistorial(archivo, fecha, tipoPago, estado, correoSolicitante);
        }
    }

    /**
     * crea el archivo para guardar el historial con los datos del primer cliente y pedido
     *
     * @param archivo
     * @param fecha
     * @param tipoPago
     * @param estado
     * @param correoSolicitante
     * @throws IOException
     */
    private void crearArchivoHistorial(File archivo, String fecha, String tipoPago, String estado, String correoSolicitante) throws IOException {
        try {
            archivo.createNewFile();
            FileWriter escribir = new FileWriter(archivo, true);
            PrintWriter imprimir = new PrintWriter(escribir);
            imprimir.println(fecha + "," + tipoPago + "," + estado + "," + correoSolicitante);
            imprimir.close();
            escribir.close();
        } catch (IOException ex) {
            System.out.println("error al crear y/o modificar el archivo historial.txt");
            ex.printStackTrace();
            throw ex;
        }
    }

    /**
     * Guarda el nuevo historial con el correo nuevo en el archivo txt de historial
     *
     * @param pedidos
     * @param correon
     */
    public void guardarNuevoHistorial(ArrayList<Pedido> pedidos, String correon) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.nombreHistorial));
            bw.write("");
            for (Pedido n : pedidos) {
                if (!n.getCorreoSolicitante().equals(correon))
                    bw.write(n.getFecha() + "," + n.getTipopago() + "," + n.getEstado() + "," + n.getCorreoSolicitante() + "\n");
            }
            bw.close();
            System.out.println("cerrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Guarda el ArrayList de pedidos en archivo txt de Historial
     *
     * @param pedidos
     */
    public void guardarHistorial(ArrayList<Pedido> pedidos) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("historial.txt"));
            bw.write("");
            Iterator iterator = pedidos.iterator();
            while (iterator.hasNext()) {
                Pedido n = (Pedido) iterator.next();
                bw.write(n.getFecha() + "," + n.getTipopago() + "," + n.getEstado() + "," + n.getCorreoSolicitante() + "\n");
            }
            bw.close();
            System.out.println("cerrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Actualiza el ArrayList de Pedidos si existe un correo Nuevo
     *
     * @param pedidos
     * @param correoa
     * @param correon
     * @return ArrayList<Pedido> con el registro de los pedidos
     */
    public ArrayList<Pedido> actualizarArrayPedidos(ArrayList<Pedido> pedidos, String correoa, String correon) {
        pedidos.stream().forEach(peds -> {
            if ((peds.getCorreoSolicitante().equals(correoa) && !correoa.equals(correon))) {
                peds.setCorreoSolicitante(correon);
                System.out.println("===========================Historial========================================================================================================================================");
                System.out.println("El nuevo nombre es:" + peds.getFecha() + "\t" + "El nuevo correo es:" + peds.getCorreoSolicitante() + "\t" + "La nueva contrasena:" + peds.getEstado());
            }
        });
        return pedidos;
    }
}
