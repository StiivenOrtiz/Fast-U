package com.fastu.fastu.Fachada;

import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.fachada.PerfilFachada;
import com.fastu.fastu.fachada.UsuariosFachada;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfilFachadaTest {
    @Test
    void actualizarTokenizarDatosEspecificpos() throws IOException {
        String Nombre = "Test";
        String correo = "test@javeriana.edu.co";
        String pw = "PwTest";
        ArrayList<Cliente> clientesTest;
        PerfilFachada actualizarDatos = new PerfilFachada();
        UsuariosFachada registroUsuario = new UsuariosFachada();
        registroUsuario.registrarUsuario(Nombre, correo, pw);
        clientesTest = actualizarDatos.TokenizarDatos();
        boolean actualiza = actualizarDatos.actualizarDatosEspecificos(clientesTest, "Test", "Test2", "test@javeriana.edu.co", "test2@javeriana.edu.co", "PwTest", "PwTest2");
        assertTrue(actualiza);
    }
}
