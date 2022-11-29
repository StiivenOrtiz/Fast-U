package com.fastu.fastu.persistencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class LecturaDatosClienteTest {
    @Test
    public void resultadoTrue() {
        LecturaDatosClientes Chan123 = new LecturaDatosClientes();
        try {
            assertFalse(Chan123.buscarCliente("Chan", "123"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void resultadoFalse() {
        LecturaDatosClientes Chan1234 = new LecturaDatosClientes();
        try {
            Assertions.assertFalse(Chan1234.buscarCliente("Chan", "1234"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
