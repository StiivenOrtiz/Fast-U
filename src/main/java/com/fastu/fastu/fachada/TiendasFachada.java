package com.fastu.fastu.fachada;

import com.fastu.fastu.Modelo.Tienda;
import com.fastu.fastu.persistencia.LecturaTiendas;

import java.io.IOException;
import java.util.ArrayList;

public class TiendasFachada {
    public Tienda buscarTienda(String tipoTienda) throws IOException {
        LecturaTiendas lecturaTiendas = new LecturaTiendas();
        ArrayList<Tienda> tiendas = lecturaTiendas.cargarTiendas();

        for (int i = 0; i < tiendas.size(); i++) {
            if (tiendas.get(i).getTipoTienda().equalsIgnoreCase(tipoTienda))
                return tiendas.get(i);
        }
        return null;
    }
}
