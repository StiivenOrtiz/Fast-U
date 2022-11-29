package com.fastu.fastu.persistencia;

import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.logica.ActualizarDatos;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ActualizarDatosTest {
    @Test
    void actualizarDatosEspecificpos() throws IOException {
        String Nombre = "Test";
        String correo = "test@javeriana.edu.co";
        String pw = "PwTest";
        ArrayList<Cliente> clientesTest;
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        RegistroUsuario registroUsuario = new RegistroUsuario();
        registroUsuario.registrarUsuario(Nombre, correo, pw);
        clientesTest = actualizarDatos.TokenizarArray();
        boolean actualiza = actualizarDatos.actualizarDatosEspecificos(clientesTest, "Test", "Test2", "test@javeriana.edu.co", "test2@javeriana.edu.co", "PwTest", "PwTest2");
        assertTrue(actualiza);
    }

    @Test
    void guardarDatos() throws IOException {
        String Nombre = "Test";
        String correo = "test@javeriana.edu.co";
        String pw = "PwTest";
        ArrayList<Cliente> clientesTest = new ArrayList<>();
        ActualizarDatos actualizarDatos = new ActualizarDatos();
        RegistroUsuario registroUsuario = new RegistroUsuario();
        LecturaDatosClientes lecturaDatosClientes = new LecturaDatosClientes();
        if (!lecturaDatosClientes.buscarCliente("test@javeriana.edu.co", "PwTest")) {
            registroUsuario.registrarUsuario(Nombre, correo, pw);
        }
        clientesTest = actualizarDatos.TokenizarArray();
        actualizarDatos.guardarDatos(clientesTest);
        assertTrue(lecturaDatosClientes.buscarCliente("test@javeriana.edu.co", "PwTest"));
    }
}