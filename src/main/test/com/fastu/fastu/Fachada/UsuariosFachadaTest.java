package com.fastu.fastu.Fachada;

import com.fastu.fastu.fachada.UsuariosFachada;
import com.fastu.fastu.persistencia.LecturaDatosClientes;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class UsuariosFachadaTest {
    @Test
    public void us() {
        UsuariosFachada registroUsuario = new UsuariosFachada();
        LecturaDatosClientes lecturaDatosClientes = new LecturaDatosClientes();
        try {
            if (!lecturaDatosClientes.buscarCliente("jorge@javeriana.edu.co", "0987"))
                assertTrue(registroUsuario.registrarUsuario("Jorge", "jorge@javeriana.edu.co", "0987"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

