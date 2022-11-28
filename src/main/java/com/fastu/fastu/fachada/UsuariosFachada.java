package com.fastu.fastu.fachada;

import com.fastu.fastu.persistencia.LecturaDatosClientes;
import com.fastu.fastu.persistencia.RegistroUsuario;

import java.io.IOException;


public class UsuariosFachada {
    /**
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
