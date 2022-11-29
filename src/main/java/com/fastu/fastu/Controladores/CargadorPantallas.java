package com.fastu.fastu.Controladores;

import com.fastu.fastu.FastU;
import com.fastu.fastu.Modelo.Tienda;
import com.fastu.fastu.Util.Constantes;
import com.fastu.fastu.fachada.TiendasFachada;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


/**
 * creador factory de pantallas y controllers
 */
public interface CargadorPantallas {
    /**
     * Encargado de llevar a cabo la acción de cargar una pantalla dado el stage y el nombre de la pantalla
     *
     * @param stage
     * @param nombrePantalla
     * @throws IOException
     */
    static void cargarPantalla(Stage stage, String nombrePantalla) throws IOException {
        Controller controller;

        switch (nombrePantalla) {
            case "Menu" -> {
                controller = new MenuController();
            }
            case "IniciarSesion" -> {
                controller = new IniciarSesionController();
            }
            case "Registro" -> {
                controller = new RegistroController();
            }
            case "PedirFavor" -> {
                controller = new PedirFavorController();
            }
            case "Producto" -> {
                controller = new ProductoController();
            }
            case "PerfilUsuario" -> {
                controller = new PerfilUsuarioController();
            }
            case "Pago" -> {
                controller = new PagoController();
            }
            case "PantallaTienda" -> {
                controller = new PantallaTiendaController();
            }
            case "Iniciar" -> {
                controller = new IniciarController();
            }
            case "Historial" -> {
                controller = new HistorialController();
            }
            default -> {
                controller = null;
            }
        }
        assert controller != null;

        String nombreFXML = Constantes.obtenerFXML(nombrePantalla);
        FXMLLoader loader = new FXMLLoader((FastU.class.getResource(nombreFXML)));
        Scene scene = new Scene(loader.load(), 375, 667);
        controller = loader.getController();
        Stage nStage = new Stage();
        nStage.setTitle(nombrePantalla);
        nStage.setScene(scene);
        nStage.getIcons().add(new Image(Objects.requireNonNull(FastU.class.getResourceAsStream(Constantes.logo))));
        controller.setStage(nStage);

        if (controller instanceof PerfilUsuarioController) {
            ((PerfilUsuarioController) controller).MostrarDatos();
        } else if (controller instanceof HistorialController) {
            ((HistorialController) controller).cargarHistorial();
            ((HistorialController) controller).MostrarHistorial();
        }

        nStage.show();
    }

    /**
     * En caso de cargar una pantalla de tienda, se pasará por parametro la tienda que se solicita
     *
     * @param tiendaSolicitada
     * @throws IOException
     */
    static void cargarTienda(String tiendaSolicitada) throws IOException {
        TiendasFachada tiendasFachada = new TiendasFachada();
        Tienda tienda = tiendasFachada.buscarTienda(tiendaSolicitada);

        if (tienda != null) {
            try {
                FXMLLoader loader = new FXMLLoader(FastU.class.getResource(Constantes.pantallaTiendaFXML));
                Scene scene = new Scene(loader.load(), 375, 667);
                PantallaTiendaController controller = loader.getController();
                controller.cargarTienda(tienda);
                Stage nStage = new Stage();
                nStage.setTitle(tiendaSolicitada);
                nStage.setScene(scene);
                nStage.getIcons().add(new Image(Objects.requireNonNull(FastU.class.getResourceAsStream(Constantes.logo))));
                controller.setStage(nStage);
                nStage.show();
            } catch (IOException ex) {
                throw ex;
            }
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error al cargar " + tiendaSolicitada);
            mensaje.setContentText("No se logró encontrar algun(a) " + tiendaSolicitada);
            mensaje.show();
        }
    }
}
