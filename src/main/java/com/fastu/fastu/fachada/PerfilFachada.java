package com.fastu.fastu.fachada;

import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.persistencia.ActualizarDatos;

import java.util.ArrayList;

public class PerfilFachada {
    public ArrayList<Cliente> TokenizarDatos() {
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        return actualizarDatos.TokenizarArray();
    }

    public boolean actualizarDatosEspecificos(ArrayList<Cliente> clientes, String nombre, String NombreNuevo, String correo, String CorreoNuevo, String contrasena, String ContrasenaNueva) {
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        return actualizarDatos.actualizarDatosEspecificos(clientes, nombre, NombreNuevo, correo, CorreoNuevo, contrasena, ContrasenaNueva);
    }

    public void guardarDatos(ArrayList<Cliente> clientes) {
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        actualizarDatos.guardarDatos(clientes);
    }
}