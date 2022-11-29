package com.fastu.fastu.fachada;

import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.logica.ActualizarDatos;
import com.fastu.fastu.observador.Observador;

import java.util.ArrayList;

/**
 * Clase de fachada para manejar el perfil del usuario
 */
public class PerfilFachada {
    /**
     * Tokeniza los datos del archivo txt en un nuevo ArrayList
     *
     * @return ArrayList<Cliente> con los datos obtenidos del archivo de texto
     */
    public ArrayList<Cliente> TokenizarDatos() {
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        return actualizarDatos.TokenizarArray();
    }

    /**
     * Actualiza los datos obtenidos de los archivos txt de datospersonales y historial
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
     * Guardar los nuevos datos de los clientes en el archivo txt
     *
     * @param clientes
     */
    public void guardarDatos(ArrayList<Cliente> clientes) {
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        actualizarDatos.guardarDatos(clientes);
    }

    /**
     * Notifica a los observadores la actualización de datos
     *
     * @param observadores
     * @return ArrayList<Observador>
     */
    public void notificar(ArrayList<Observador> observadores) {
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        actualizarDatos.notificar(observadores);
    }
}