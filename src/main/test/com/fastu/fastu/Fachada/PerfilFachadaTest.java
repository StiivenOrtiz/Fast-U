package com.fastu.fastu.Fachada;

import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.fachada.PerfilFachada;
import com.fastu.fastu.fachada.UsuariosFachada;
import com.fastu.fastu.persistencia.LecturaDatosClientes;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfilFachadaTest {
    @Test
    void actualizarTokenizarDatosEspecificpos(){
        String Nombre = "Test";
        String correo = "test@javeriana.edu.co";
        String pw = "PwTest";
        ArrayList<Cliente> clientesTest;
        PerfilFachada actualizarDatos = new PerfilFachada();
        UsuariosFachada registroUsuario = new UsuariosFachada();

        LecturaDatosClientes lecturaDatosClientes = new LecturaDatosClientes();
        try {
            if (!lecturaDatosClientes.buscarCliente(correo, pw)){
                registroUsuario.registrarUsuario(Nombre, correo, pw);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clientesTest = actualizarDatos.TokenizarDatos();
        boolean actualiza = actualizarDatos.actualizarDatosEspecificos(clientesTest, "Test", "Test2", "test@javeriana.edu.co", "test2@javeriana.edu.co", "PwTest", "PwTest2");
        assertTrue(actualiza);
    }
}
