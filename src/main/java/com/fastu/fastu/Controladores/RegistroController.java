package com.fastu.fastu.Controladores;

import com.fastu.fastu.fachada.UsuariosFachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase para controlar la pantalla de registro
 */
public class RegistroController implements Controller {
    static String Nombre;
    static String correo;
    static String pw;
    Stage stage;
    @FXML
    private Button BotonRegistrar;
    @FXML
    private PasswordField Contrasena;
    @FXML
    private TextField Correo;
    @FXML
    private TextField NombreCompleto;

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
     * Obtiene los datos de un cliente y los guarda en variable locales de la clase
     */
    void obtenerDatos() {
        Nombre = NombreCompleto.getText();
        correo = Correo.getText();
        pw = Contrasena.getText();
    }

    /**
     * para el boton de registrar, si este se logra registrar cambia a la pantalla de menu, de lo contrario se le notifica al usuario
     *
     * @param event
     */
    @FXML
    void BotonRegistrar(ActionEvent event) {
        obtenerDatos();
        UsuariosFachada usuariosFachada = new UsuariosFachada();
        try {
            if (usuariosFachada.registrarUsuario(Nombre, correo, pw))
                Controller.cargarPantalla("Menu", this.stage);
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("No se pudo realizar un registro!");
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No se pudo abrir el archivo!");
        }
    }

    /**
     * Getter para nombre
     *
     * @return
     */
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        RegistroController.correo = correo;
    }

    /**
     * Getter para retornar la contraseña del objeto
     *
     * @return contraseña
     */
    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        RegistroController.pw = pw;
    }
}
