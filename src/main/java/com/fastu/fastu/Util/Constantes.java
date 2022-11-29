package com.fastu.fastu.Util;

public interface Constantes {

    /*NOMBRES CONSTANTES PARA LA LECTURA/ESCRITUARA DE LOS TXT*/
    String nombreDatosClientes = "datosPersonales.txt";
    String nombreDatosTiendas = "datosTiendas.txt";
    String nombreHistorial = "historial.txt";

    /*NOMBRES CONSTANTES PARA LOS FXML*/
    String historialFXML = "FXML/Historial.fxml";
    String iniciarFXML = "FXML/Iniciar.fxml";
    String iniciarSesionFXML = "FXML/iniciarSesion.fxml";
    String menuFXML = "FXML/menu.fxml";
    String pagoFXML = "FXML/Pago.fxml";
    String pantallaTiendaFXML = "FXML/PantallaTienda.fxml";
    String pedirFavorFXML = "FXML/pedirfavor.fxml";
    String perfilUsuarioFXML = "FXML/PerfilUsuario.fxml";
    String productoFXML = "FXML/Producto.fxml";
    String registroFXML = "FXML/registro.fxml";

    /*NOMBRES CONSTANTES PARA LAS IMAGENES USADAS*/
    String logo = "logo.png";

    /*CORREOS*/
    String correoJaveriana = "@javeriana.edu.co";

    /**
     * Obtiene el nombre del archivo fxml según el nombre de la pantalla
     *
     * @param nombrePantalla
     * @return el nombre del archivo.fxml de la pantalla que se le pasa por parametro
     */
    static String obtenerFXML(String nombrePantalla) {
        switch (nombrePantalla) {
            case "Menu" -> {
                return Constantes.menuFXML;
            }
            case "IniciarSesion" -> {
                return Constantes.iniciarSesionFXML;
            }
            case "Registro" -> {
                return Constantes.registroFXML;
            }
            case "PedirFavor" -> {
                return Constantes.pedirFavorFXML;
            }
            case "Producto" -> {
                return Constantes.productoFXML;
            }
            case "PerfilUsuario" -> {
                return Constantes.perfilUsuarioFXML;
            }
            case "Pago" -> {
                return Constantes.pagoFXML;
            }
            case "PantallaTienda" -> {
                return Constantes.pantallaTiendaFXML;
            }
            case "Iniciar" -> {
                return Constantes.iniciarFXML;
            }
            case "Historial" -> {
                return Constantes.historialFXML;
            }
            default -> {
                return "";
            }
        }
    }

}
