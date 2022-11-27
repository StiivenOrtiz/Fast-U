package com.fastu.fastu.Controladores;

import com.fastu.fastu.fachada.UsuariosFachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class IniciarSesionController implements Controller {
    Stage stage;
    @FXML
    private Button botonIniciarSesion;
    @FXML
    private Text idErrorInicioSesion;
    @FXML
    private TextField idCorreo;
    @FXML
    private PasswordField idContrasena;
    @FXML
    private Button idBotonRegistro;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void leerArchivo() {
        String correo = idCorreo.getText();
        String contrasena = idContrasena.getText();

        UsuariosFachada leerClientesFachada = new UsuariosFachada();
        try {
            if (leerClientesFachada.buscarDatosCliente(correo, contrasena)) {
                idErrorInicioSesion.setText("La cuenta ha sido encontrada.");
                Controller.cargarPantalla("Menu", this.stage);
            } else {
                idErrorInicioSesion.setText("La cuenta o contraseña son incorrectas.");
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No se pudo abrir el archivo!");
        }
    }

    @FXML
    void accionIniciarSesion(ActionEvent event) {
        leerArchivo();
    }

    @FXML
    void irRegistro(ActionEvent event) {
        Controller.cargarPantalla("Registro", this.stage);
    }
}

