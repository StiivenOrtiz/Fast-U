package com.fastu.fastu.persistencia;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistroUsuarioTest {

    @Test
    public void usuarioRegistrado() {
        RegistroUsuario registroUsuario = new RegistroUsuario();
        LecturaDatosClientes lecturaDatosClientes = new LecturaDatosClientes();
        try {
            if (!lecturaDatosClientes.buscarCliente("jorge@javeriana.edu.co", "0987"))
                assertTrue(registroUsuario.registrarUsuario("Jorge", "jorge@javeriana.edu.co", "0987"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
