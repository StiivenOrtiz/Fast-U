package com.fastu.fastu.Controladores;

import com.fastu.fastu.Modelo.Producto;
import com.fastu.fastu.memento.CaretakerProducto;
import com.fastu.fastu.memento.OriginatorProducto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Clase para controlar los productos
 */
public class ProductoController implements Controller {
    Producto producto;
    Stage stage;
    CaretakerProducto caretaker = new CaretakerProducto();
    OriginatorProducto originator = new OriginatorProducto();
    @FXML
    private Circle imagenProducto;
    @FXML
    private TextField nombreProducto;
    @FXML
    private TextField precio;

    /**
     * Establece un elemento set en la variable stage de esta clase
     *
     * @param stage
     */
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Establece toda la informacion de un producto
     *
     * @param aa
     */
    public void setData(Producto aa) {
        this.producto = aa;
        nombreProducto.setText(this.producto.getNombre());
        precio.setText(String.valueOf(this.producto.getPrecio()));
        imagenProducto.setStroke(Color.SEAGREEN);
        Image im = new Image("com/fastu/fastu/Imagenes Tiendas/" + this.producto.getImagen(), false);
        imagenProducto.setFill(new ImagePattern((im)));
        originator.setEstado(producto);
        caretaker.addMemento(OriginatorProducto.guardar());
    }

}
