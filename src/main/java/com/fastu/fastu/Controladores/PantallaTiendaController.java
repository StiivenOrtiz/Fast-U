package com.fastu.fastu.Controladores;

import com.fastu.fastu.FastU;
import com.fastu.fastu.Modelo.Tienda;
import com.fastu.fastu.Util.Constantes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaTiendaController implements Controller {
    Stage stage;
    @FXML
    private TextField calificacion;
    @FXML
    private TextField costoEnvio;
    @FXML
    private Circle fotoPerfil;
    @FXML
    private GridPane gridPane;
    @FXML
    private HBox hBox;
    @FXML
    private TextField nombreTienda;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TextField tiempoEntrega;
    @FXML
    private Button botonRegresar;
    private Tienda tienda = null;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * para el boton volver, cambia de pantalla al menu
     * @param event
     */
    @FXML
    void regresar(ActionEvent event) {
        Controller.cargarPantalla("Menu", this.stage);
    }


    public void cargarTienda(Tienda tienda) {
        this.tienda = tienda;
        if (this.tienda != null) {
            try {
                int fila = 0;
                this.nombreTienda.setText(this.tienda.getNombreTienda());
                this.costoEnvio.setText(String.valueOf(this.tienda.getCostoEnvio()));
                this.tiempoEntrega.setText(String.valueOf(this.tienda.getTiempoEntrega()));
                this.calificacion.setText(String.valueOf(this.tienda.getCalificacion()));
                this.fotoPerfil.setStroke(Color.SEAGREEN);
                Image im = new Image("com/fastu/fastu/Imagenes Tiendas/" + this.tienda.getImagenTienda(), false);
                this.fotoPerfil.setFill(new ImagePattern((im)));
                for (int i = 0; i < this.tienda.getProductos().size(); i++) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(FastU.class.getResource(Constantes.productoFXML));
                    AnchorPane anchorPane = fxmlLoader.load();
                    ProductoController productoController = fxmlLoader.getController();
                    productoController.setData(this.tienda.getProductos().get(i));
                    gridPane.add(anchorPane, 0, fila++);
                    GridPane.setMargin(anchorPane, new Insets(0));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
