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

    @FXML
    void iniciarPapeleria(ActionEvent event) throws IOException {
        cargarTienda("Papeleria");
    }

    @FXML
    void iniciarRestaurante(ActionEvent event) throws IOException {
        cargarTienda("Restaurante");
    }

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


    @FXML
    void iniciarFavores(ActionEvent event) {
        Controller.cargarPantalla("PedirFavor", this.stage);
    }

    // BOTON PERFIL USUARIO
    @FXML
    private void eventPerfil(ActionEvent event) {
        Controller.cargarPantalla("PerfilUsuario", this.stage);
    }
}
