package com.fastu.fastu.Controladores;

import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.fachada.PerfilFachada;
import com.fastu.fastu.observador.Observador;
import com.fastu.fastu.observador.SujetoObservable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PerfilUsuarioController implements Controller, SujetoObservable {
    RegistroController registro = new RegistroController();
    String nombre = registro.getNombre();
    String correo = registro.getCorreo();
    String contrasena = registro.getPw();
    ArrayList<Cliente> clientes = new ArrayList();
    Cliente objeto = null;
    Stage stage;
    private ArrayList<Observador> observadores = new ArrayList();
    @FXML
    private TextField NombreCompleto;
    @FXML
    private TextField Correo;
    @FXML
    private TextField Contrasena;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void notificar() {
        for (Observador o : observadores) {
            o.update();
        }
    }

    public void enlazarObservador(Observador o) {
        observadores.add(o);
    }

    @FXML
    void BotonHistorial(ActionEvent event) {
        Controller.cargarPantalla("Historial", this.stage);
    }

    @FXML
    void BotonVolver(ActionEvent event) {
        Controller.cargarPantalla("Menu", this.stage);
    }

    @FXML
    void BotonAceptar(ActionEvent event) throws IOException {
        try {
            PerfilFachada perfilFachada = new PerfilFachada();
            this.clientes = perfilFachada.TokenizarDatos();
        } catch (Exception var12) {
            System.out.println("accion no valida");
        }

        actualizarDatosEspecificos();
        guardarDatos();
        clientes.clear();
    }

    public void PerfilUsuario() {
        observadores = new ArrayList<Observador>();
    }

    public void actualizarDatosEspecificos() {
        String NombreNuevo = NombreCompleto.getText();
        String CorreoNuevo = Correo.getText();
        String ContrasenaNueva = Contrasena.getText();
        PerfilFachada perfilFachada = new PerfilFachada();
        if (perfilFachada.actualizarDatosEspecificos(clientes, nombre, NombreNuevo, correo, CorreoNuevo, contrasena, ContrasenaNueva)) {
            this.nombre = NombreNuevo;
            this.correo = CorreoNuevo;
            this.contrasena = ContrasenaNueva;

        }
    }

    public void MostrarDatos() {
        NombreCompleto.setText(nombre);
        Correo.setText(correo);
        Contrasena.setText(contrasena);
    }

    public void guardarDatos() {
        try {
            PerfilFachada perfilFachada = new PerfilFachada();
            perfilFachada.guardarDatos(this.clientes);
        } catch (Exception var13) {
            System.out.println(var13.getMessage());
        }
    }
}
