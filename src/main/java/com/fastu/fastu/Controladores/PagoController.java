package com.fastu.fastu.Controladores;

import com.fastu.fastu.fachada.RealizarPedidoFachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Clase para controlar la pantalla para el pago de productos
 */
public class PagoController implements Initializable, Controller {
    private final String[] metodosPago = {"Efectivio", "Tarjeta"};
    PedirFavorController pedirFavorController;
    String tipoPagoAUX = null;
    String dirEntrega = "";
    String notas = null;
    String descripcion = "";
    String cambioPago = "";
    String numTarjeta = "";
    @FXML
    private Button idCancelar;
    @FXML
    private Button idEditar;
    @FXML
    private Button idRealizarPedido;
    @FXML
    private TextField idDescripcion;
    @FXML
    private TextField idDinero;
    @FXML
    private TextField idDireccion;
    @FXML
    private TextField idNotas;
    @FXML
    private TextField idTarjeta;
    @FXML
    private ChoiceBox<String> idMetodoPago;
    @FXML
    private Label idMensajes;
    @FXML
    private Label prueba;
    private Stage stage;

    /**
     * Obtener la seleccion del ChoiceBox
     *
     * @param arg0 The location used to resolve relative paths for the root object, or
     *             {@code null} if the location is not known.
     * @param arg1 The resources used to localize the root object, or {@code null} if
     *             the root object was not localized.
     */
    @Override ////////// METER LOS DATOS EN LOS CHOICE BOX
    public void initialize(URL arg0, ResourceBundle arg1) {
        idMetodoPago.getItems().addAll(metodosPago);
        idMetodoPago.setOnAction(this::getTipoPago);
    }

    /**
     * Boton para realizar un pedido, el cual verifica  que todos los campos esten llenos
     *
     * @param event
     */
    @FXML
    private void eventRealizarPedido(ActionEvent event) {
        iniciarDatos();

        if (dirEntrega == "" || descripcion == "") {
            idMensajes.setText("INGRESE LA DIRECCION Y/O DESCRIPCION");
        } else {
            // VERIFICANDO SI ES TARJETA O EFECTIVO
            if (tipoPagoAUX == null) { // SI NO SE HA ESCOGIDO EL METODO DE PAGO
                idMensajes.setText("INGRESE EL METODO DE PAGO");

            } else if (tipoPagoAUX.equals(metodosPago[1])) { // TARJETA
                if (numTarjeta == "") {
                    idMensajes.setText("INGRESE NUMERO DE TARJETA");
                } else {
                    // BUSCAR TARJETA EN TXT, RESTAR SALDO AL USUARIO Y SUMARLE AL DOMICILIARIO
                    idMensajes.setText("PEDIDO REALIZADO");
                }
            } else if (tipoPagoAUX.equals(metodosPago[0])) { // EFECTIVO
                if (cambioPago == "") {
                    idMensajes.setText("INGRESE EL BILLETE");
                } else {
                    idMensajes.setText("PEDIDO REALIZADO");
                }
            }
        }
        RealizarPedidoFachada realizarPedido = new RealizarPedidoFachada();
        realizarPedido.registrarPedido();
    }

    /**
     * Boton para editar la descripción del pedido
     *
     * @param event
     */
    @FXML
    private void eventEditar(ActionEvent event) {
        Controller.cargarPantalla("PedirFavor", this.stage);
    }

    /**
     * Boton para cancelar el pedido realizado y regresar a la pantalla anterior
     *
     * @param event
     */
    @FXML
    private void eventCancelar(ActionEvent event) {
        Controller.cargarPantalla("PedirFavor", this.stage);
    }

    /**
     * inicializar pedirFavorController
     *
     * @param pedirFavorController
     */
    public void init(PedirFavorController pedirFavorController) {
        this.pedirFavorController = pedirFavorController;
    }

    /**
     * inicializa los datos obtenidos de la pantalla
     */
    private void iniciarDatos() {
        getDirEntrega();
        getNotas();
        getDescripcion();
        getCambioPago();
        getTarjeta();
    }

    /**
     * Guarda los datos seleccionados por el usuario
     *
     * @param event
     */
    public void getTipoPago(ActionEvent event) {
        tipoPagoAUX = idMetodoPago.getValue();
    }

    public void getDirEntrega() {
        dirEntrega = idDireccion.getText();
    }

    public void getNotas() {
        notas = idNotas.getText();
    }

    public void getDescripcion() {
        descripcion = idDescripcion.getText();
    }

    public void getCambioPago() {
        cambioPago = idDinero.getText();
    }

    public void getTarjeta() {
        numTarjeta = idTarjeta.getText();
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
