package com.fastu.fastu.Controladores;

import com.fastu.fastu.Modelo.Pedido;
import com.fastu.fastu.comando.IOperacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class PagoController extends ControllerAuxPago implements Initializable, IOperacion {
    private final String[] metodosPago = {"Efectivio", "Tarjeta"};
    PedirFavorController pedirFavorController;
    String tipoPagoAUX = null;
    String dirEntrega = "";
    String notas = null;
    String descripcion = "";
    String cambioPago = "";
    String numTarjeta = "";

    ////////////////////////////////////////////////////////////////////////////

    // BOTONES
    @FXML
    private Button idCancelar;
    @FXML
    private Button idEditar;
    @FXML
    private Button idRealizarPedido;

    // TEXTFIELDS
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

    // CHOICE BOX
    @FXML
    private ChoiceBox<String> idMetodoPago;

    // LABELS
    @FXML
    private Label idMensajes;
    @FXML
    private Label prueba;

    ////////////////////////////////////////////////////////////////////////////

    @Override ////////// METER LOS DATOS EN LOS CHOICE BOX
    public void initialize(URL arg0, ResourceBundle arg1) {
        idMetodoPago.getItems().addAll(metodosPago);
        idMetodoPago.setOnAction(this::getTipoPago);
    }

    //////// GUARDAR LOS VALORES SELECCIONADO POR EL USUARIO
    public void getTipoPago(ActionEvent event) {
        tipoPagoAUX = idMetodoPago.getValue();
    }

    // TEXTFIELDS
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

    private void iniciarDatos() {
        getDirEntrega();
        getNotas();
        getDescripcion();
        getCambioPago();
        getTarjeta();
    }


    // VERIFICANDO QUE TODOS LOS CAMPOS ESTEN LLENOS
    // VERIFICAICON SE HACE CUANDO SE PRESIONE EL BOTON "REALIZAR PEDIDO"

    // BOTON REALIZAR PEDIDO
    @FXML
    private void eventRealizarPedido(ActionEvent event) {
        iniciarDatos();
        String met = metodosPago[1];
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
        int m = (int) Math.floor(Math.random() * 5);
        String estado;

        // 0 -> No realizado, 1 -> En preparación, 2 -> En trayecto, 3 -> Cancelado // 4 -> Entregado
        switch (m) {
            case 1:
                estado = "En preparación";
                break;
            case 2:
                estado = "En trayecto";
                break;
            case 3:
                estado = "Cancelado";
                break;
            case 4:
                estado = "Entregado";
                break;
            default:
                estado = "No realizado";
                break;
        }

        RegistroController registro = new RegistroController();
        String fecha = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        Pedido ped = new Pedido(fecha, met, estado, registro.getCorreo());
        HistorialController historialController = new HistorialController();
        historialController.agregarEnHistorial(ped);
    }

    // BOTON EDITAR
    @FXML
    private void eventEditar(ActionEvent event) {
        Controller.cargarPantalla("PedirFavor", this.stage);
    }

    // BOTON CANCELAR
    @FXML
    private void eventCancelar(ActionEvent event) {
        Controller.cargarPantalla("PedirFavor", this.stage);
    }

    public void init(PedirFavorController pedirFavorController) {
        this.pedirFavorController = pedirFavorController;
    }
}
