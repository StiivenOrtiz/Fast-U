package com.fastu.fastu.Fachada;

import com.fastu.fastu.fachada.UsuariosFachada;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class UsuariosFachadaTest {
    @Test
    public void us() {
        UsuariosFachada registroUsuario = new UsuariosFachada();
        try {
            assertTrue(registroUsuario.registrarUsuario("Jorge", "jorge@javeriana.edu.co", "0987"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

