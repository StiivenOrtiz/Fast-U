package com.fastu.fastu.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

//oka xd
public class MenuController implements Controller {
    Stage stage;
    @FXML
    private Button ClickQuejas;
    @FXML
    private Button eventPerfil;
    @FXML
    private ImageView imagenperfil;
    @FXML
    private Button papeleriaButton;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * para el boton de papeleria, cambia de pantalla a la papeleria
     * @param event
     * @throws IOException
     */
    @FXML
    void iniciarPapeleria(ActionEvent event) throws IOException {
        cargarTienda("Papeleria");
    }

    /**
     * para el boton de restaurante, cambia de pantalla a restaurantes
     * @param event
     * @throws IOException
     */
    @FXML
    void iniciarRestaurante(ActionEvent event) throws IOException {
        cargarTienda("Restaurante");
    }

    /**
     * para el boton de tienda, cambia de pantalla a tiendas
     * @param event
     * @throws IOException
     */
    @FXML
    void iniciarTiendas(ActionEvent event) throws IOException {
        cargarTienda("Tienda");
    }

    private void cargarTienda(String tiendaSolicitada) {
        try {
            CargadorPantallas.cargarTienda(tiendaSolicitada);
        } catch (IOException ex) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error al cargar la pantalla");
            mensaje.setContentText("No se logró cargar la pantalla  " + tiendaSolicitada);
            mensaje.show();
        }
        this.stage.close();
    }


    /**
     * para el boton de favores, cambia de pantalla a favores
     * @param event
     */
    @FXML
    void iniciarFavores(ActionEvent event) {
        Controller.cargarPantalla("PedirFavor", this.stage);
    }

    /**
     * para el boton del usuarion, cambia de pantalla al perfil del usuario
     * @param event
     */
    @FXML
    private void eventPerfil(ActionEvent event) {
        Controller.cargarPantalla("PerfilUsuario", this.stage);
    }
}
