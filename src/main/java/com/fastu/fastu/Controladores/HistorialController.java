package com.fastu.fastu.Controladores;

import com.fastu.fastu.Modelo.Pedido;
import com.fastu.fastu.fachada.HistorialFachada;
import com.fastu.fastu.observador.Observador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HistorialController implements Controller, Observador {
    static String correoa;
    RegistroController registro = new RegistroController();
    String correon = registro.getCorreo();
    ObservableList<Pedido> PED;
    ArrayList<Pedido> Datosobtenidos = new ArrayList<Pedido>();
    ArrayList<Pedido> pedidos = new ArrayList();
    Pedido objeto = null;
    Stage stage;

    @FXML
    private TableView<Pedido> TABLA;
    @FXML
    private TableColumn Estado;
    @FXML
    private TableColumn Tipo;
    @FXML
    private TableColumn Fecha;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void update() {
        System.out.println("Actualizando historial");
        actualizarHistorial();
    }


    @FXML
    private void BotonEliminar(ActionEvent event) throws IOException {
        cargarHistorial();
        guardarHistorial();
        TABLA.getItems().clear();
    }

    @FXML
    private void BotonRegresar(ActionEvent event) {
        Controller.cargarPantalla("PerfilUsuario", this.stage);
    }

    public void MostrarHistorial() {
        RegistroController registro = new RegistroController();
        HistorialFachada historialFachada = new HistorialFachada();
        try {
            this.Datosobtenidos = historialFachada.consultarHistorialPorCorreo(registro.getCorreo());
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No se pudo abrir el archivo!");
        }
        this.PED = FXCollections.observableArrayList(this.Datosobtenidos);
        TABLA.setItems(PED);
        this.Fecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.Tipo.setCellValueFactory(new PropertyValueFactory("tipopago"));
        this.Estado.setCellValueFactory(new PropertyValueFactory("estado"));
    }

    public void cargarHistorial() {
        try {
            HistorialFachada historialFachada = new HistorialFachada();
            this.pedidos = historialFachada.cargarHistorial();
        } catch (Exception var12) {
            System.out.println("accion no valida");
        }
    }

    public void guardarHistorial() {
        try {
            HistorialFachada historialFachada = new HistorialFachada();
            historialFachada.guardarNuevoHistorial(this.pedidos, correon);
        } catch (Exception var13) {
            System.out.println(var13.getMessage());
            System.out.println("No se pudo guardar el nuevo historial");
        }
        this.pedidos.clear();
    }

    public void agregarEnHistorial(Pedido pedido) {
        try {
            HistorialFachada historialFachada = new HistorialFachada();
            historialFachada.adicionarRegistroHistorial(pedido.getFecha(), pedido.getTipopago(), pedido.getEstado(), registro.getCorreo());
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No se pudo abrir el archivo!");
        }
    }

    public void actualizarHistorial() {
        cargarHistorial();
        this.correon = registro.getCorreo();
        HistorialFachada historialFachada = new HistorialFachada();
        pedidos = historialFachada.actualizarArrayPedidos(pedidos, correoa, correon);
        try {
            historialFachada.guardarHistorial(this.pedidos);
        } catch (Exception var13) {
            System.out.println(var13.getMessage());
        }
        pedidos.clear();
    }

    public void setCorreoa(String correoa) {
        HistorialController.correoa = correoa;
    }
}
