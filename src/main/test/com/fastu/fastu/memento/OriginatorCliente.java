package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OriginatorCliente {

    @Test
    public void pruebeOriginator(OriginatorCliente o) {

        Cliente estado = new Cliente();

        estado.setNombreCompleto("fabian");
        estado.setCorreo("fab@javeriana.edu.co");
        estado.setContrasena("1234");

        MementoCliente mem = new MementoCliente(estado);

        Cliente prueba = mem.getEstado();

        assertEquals("fabian", prueba.getNombreCompletos());
    }
}
