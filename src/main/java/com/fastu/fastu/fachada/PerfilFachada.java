package com.fastu.fastu.fachada;

import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.persistencia.ActualizarDatos;

import java.util.ArrayList;

public class PerfilFachada {
    public ArrayList<Cliente> TokenizarDatos() {
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        return actualizarDatos.TokenizarArray();
    }

    /**
     *
     * @param clientes
     * @param nombre
     * @param NombreNuevo
     * @param correo
     * @param CorreoNuevo
     * @param contrasena
     * @param ContrasenaNueva
     * @return dependiendo al dato ingresado (anteriores), este se actualiza en el txt de registros
     */
    public boolean actualizarDatosEspecificos(ArrayList<Cliente> clientes, String nombre, String NombreNuevo, String correo, String CorreoNuevo, String contrasena, String ContrasenaNueva) {
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        return actualizarDatos.actualizarDatosEspecificos(clientes, nombre, NombreNuevo, correo, CorreoNuevo, contrasena, ContrasenaNueva);
    }

    /**
     *
     * @param clientes
     */
    public void guardarDatos(ArrayList<Cliente> clientes) {
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        actualizarDatos.guardarDatos(clientes);
    }
}