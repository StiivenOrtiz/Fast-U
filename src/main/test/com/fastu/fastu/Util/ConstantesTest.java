package com.fastu.fastu.Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantesTest {

    @Test
    void obtenerFXMLMenu() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("Menu");
        assertEquals(Constantes.menuFXML, pruebaFXML);
    }

    @Test
    void obtenerFXMLIniciarSesion() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("IniciarSesion");
        assertEquals(Constantes.iniciarSesionFXML, pruebaFXML);
    }

    @Test
    void obtenerFXMLRegistro() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("Registro");
        assertEquals(Constantes.registroFXML, pruebaFXML);
    }

    @Test
    void obtenerFXMLPedirFavor() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("PedirFavor");
        assertEquals(Constantes.pedirFavorFXML, pruebaFXML);
    }

    @Test
    void obtenerFXMLProducto() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("Producto");
        assertEquals(Constantes.productoFXML, pruebaFXML);
    }

    @Test
    void obtenerFXMLPerfilUsuario() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("PerfilUsuario");
        assertEquals(Constantes.perfilUsuarioFXML, pruebaFXML);
    }

    @Test
    void obtenerFXMLPago() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("Pago");
        assertEquals(Constantes.pagoFXML, pruebaFXML);
    }

    @Test
    void obtenerFXMLPantallaTienda() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("PantallaTienda");
        assertEquals(Constantes.pantallaTiendaFXML, pruebaFXML);
    }

    @Test
    void obtenerFXMLIniciar() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("Iniciar");
        assertEquals(Constantes.iniciarFXML, pruebaFXML);
    }

    @Test
    void obtenerFXMLDefault() {
        String pruebaFXML;
        pruebaFXML = Constantes.obtenerFXML("PRUEBA");
        assertEquals("", pruebaFXML);
    }

    @Test
    void correo() {
        String correo = "@javeriana.edu.co";
        assertEquals(Constantes.correoJaveriana, correo);
    }

    @Test
    void logo() {
        String logo = "logo.png";
        assertEquals(Constantes.logo, logo);
    }

    @Test
    void datosClientes() {
        String datosClientes = "datosPersonales.txt";
        assertEquals(Constantes.nombreDatosClientes, datosClientes);
    }

    @Test
    void DatosTiendas() {
        String DatosTiendas = "datosTiendas.txt";
        assertEquals(Constantes.nombreDatosTiendas, DatosTiendas);
    }

    @Test
    void Historial() {
        String historial = "historial.txt";
        assertEquals(Constantes.nombreHistorial, historial);
    }
}