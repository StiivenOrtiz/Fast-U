package com.fastu.fastu.fachada;

import com.fastu.fastu.persistencia.LecturaDatosClientes;
import com.fastu.fastu.persistencia.RegistroUsuario;

import java.io.IOException;

/**
 * Clase para la Fachada del manejo de usuarios
 */
public class UsuariosFachada {
    /**
     * Busca los datos del cliente en archivo de datos personales por correo y contraseña
     *
     * @param correo
     * @param contrasena
     * @return fachada para buscar un cliente en el registro
     * @throws IOException
     */
    public boolean buscarDatosCliente(String correo, String contrasena) throws IOException {
        LecturaDatosClientes lecturaDatosClientes = new LecturaDatosClientes();
        return lecturaDatosClientes.buscarCliente(correo, contrasena);
    }

    /**
     * Registra un nuevo usuario en el archivo txt de datospersonales
     *
     * @param nombre
     * @param correo
     * @param contrasena
     * @return fachada para registrar un cliente
     * @throws IOException
     */
    public boolean registrarUsuario(String nombre, String correo, String contrasena) throws IOException {
        RegistroUsuario registroUsuario = new RegistroUsuario();
        return registroUsuario.registrarUsuario(nombre, correo, contrasena);
    }
}
