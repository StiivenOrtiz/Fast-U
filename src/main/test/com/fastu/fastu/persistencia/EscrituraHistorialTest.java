package com.fastu.fastu.persistencia;

import com.fastu.fastu.Modelo.Pedido;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

public class EscrituraHistorialTest {
    @Test
    void testLecturaHistorial() {
        LecturaHistorial lecturaHistorial = new LecturaHistorial();
        EscrituraHistorial escrituraHistorial = new EscrituraHistorial();
        ArrayList<Pedido> peds;
        ArrayList<Pedido> pedsNuevo;
        try {
            escrituraHistorial.agregarHistorial("27/11/2022", "Efectivo", "Cancelado", "test@testE.com");
            peds = lecturaHistorial.leerHistorialPedidos("test@testE.com");
            pedsNuevo = escrituraHistorial.actualizarArrayPedidos(peds, "test@testE.com", "test@testEN.com");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals("test@testEN.com", pedsNuevo.get(0).getCorreoSolicitante());
    }
}