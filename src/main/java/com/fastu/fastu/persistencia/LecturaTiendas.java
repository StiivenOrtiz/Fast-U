package com.fastu.fastu.persistencia;

import com.fastu.fastu.Modelo.Producto;
import com.fastu.fastu.Modelo.Tienda;
import com.fastu.fastu.Util.Constantes;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaTiendas {
    public ArrayList<Tienda> cargarTiendas() throws IOException {
        ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("datosTiendas.txt"));
            String cadena;
            int productos = 0;
            Tienda tiendaAux = null;
            ArrayList<Producto> productosL = new ArrayList<Producto>();

            while ((cadena = br.readLine()) != null) {
                String[] divisiones = cadena.split(",");

                if (productos == 0) {
                    tiendaAux = new Tienda(divisiones[0], divisiones[1], divisiones[2], Float.parseFloat(divisiones[3]), Float.parseFloat(divisiones[4]), Float.parseFloat(divisiones[5]), divisiones[6]);
                    productos = Integer.parseInt(divisiones[7]);
                } else if (productos > 0) {
                    productosL.add(new Producto(divisiones[0], Float.parseFloat(divisiones[1]), divisiones[2], divisiones[3]));
                    productos--;
                    if (productos == 0) {
                        tiendaAux.setProductos(productosL);
                        tiendas.add(tiendaAux);
                        tiendaAux = null;
                        productosL.clear();
                    }
                }
            }
        } catch (IOException ex) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error en lectura");
            mensaje.setContentText("No se logro leer el archivo " + Constantes.nombreDatosClientes);
            mensaje.show();
            throw ex;
        }
        return tiendas;
    }
}
