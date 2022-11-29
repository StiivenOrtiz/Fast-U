package com.fastu.fastu.memento;

import com.fastu.fastu.Modelo.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaretakerClienteTest {

    @Test
    public void pruebaDeCaretaker() {

        CaretakerCliente m = new CaretakerCliente();
        Cliente cliente = new Cliente();
        cliente.setNombreCompleto("fabian");
        cliente.setCorreo("fab@javeriana.edu.co");
        cliente.setContrasena("1234");
        MementoCliente mem = new MementoCliente(cliente);
        m.addMemento(mem);
        Cliente cliente1 = new Cliente();
        cliente1 = m.getMemento(0).getEstado();

        assertEquals("fabian", cliente1.getNombreCompletos());
    }


}
