package com.fastu.fastu.Controladores;

import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.fachada.PerfilFachada;
import com.fastu.fastu.memento.CaretakerCliente;
import com.fastu.fastu.memento.OriginatorCliente;
import com.fastu.fastu.observador.Observador;
import com.fastu.fastu.observador.SujetoObservable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase para controlar la pantalla del PerfilUsuario
 */
public class PerfilUsuarioController implements Controller, SujetoObservable {
    RegistroController registro = new RegistroController();
    String nombre = registro.getNombre();
    String correo = registro.getCorreo();
    String contrasena = registro.getPw();
    ArrayList<Cliente> clientes = new ArrayList();
    Cliente objeto = null;
    Cliente cliente;
    Stage stage;
    CaretakerCliente caretaker = new CaretakerCliente();
    OriginatorCliente originatorCliente = new OriginatorCliente();
    private ArrayList<Observador> observadores = new ArrayList();
    @FXML
    private TextField NombreCompleto;
    @FXML
    private TextField Correo;
    @FXML
    private TextField Contrasena;

    /**
     * El nuevo escenario construido para la nueva pantalla
     *
     * @param stage
     */
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Notifica a todos los observadores el cambio realizado
     */
    @Override
    public void notificar() {
        PerfilFachada perfilFachada = new PerfilFachada();
        perfilFachada.notificar(observadores);
    }

    /**
     * Enlaza un nuevo observador al arreglo de observadores
     *
     * @param o
     */
    public void enlazarObservador(Observador o) {
        observadores.add(o);
    }

    /**
     * Boton para ir a la pantalla historial del usuario correspondiente
     *
     * @param event
     */
    @FXML
    void BotonHistorial(ActionEvent event) {
        Controller.cargarPantalla("Historial", this.stage);
    }

    /**
     * Boton para regresar a la pantalla menu
     *
     * @param event
     */
    @FXML
    void BotonVolver(ActionEvent event) {
        Controller.cargarPantalla("Menu", this.stage);
    }

    /**
     * Boton para aceptar los cambios realizados en los datos del perfil
     *
     * @param event
     * @throws IOException
     */
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

    /**
     * Constructor para PerfilUsuarioController()
     */
    public void PerfilUsuarioController() {
        observadores = new ArrayList<Observador>();
    }

    /**
     * Actualiza los datos de nombre, correo y contraseña en los arreglos de cliente, historial, uduarioresgistrado
     */
    public void actualizarDatosEspecificos() {
        String NombreNuevo = NombreCompleto.getText();
        String CorreoNuevo = Correo.getText();
        String ContrasenaNueva = Contrasena.getText();
        PerfilFachada perfilFachada = new PerfilFachada();
        HistorialController historial = new HistorialController();
        if (perfilFachada.actualizarDatosEspecificos(clientes, nombre, NombreNuevo, correo, CorreoNuevo, contrasena, ContrasenaNueva)) {
            enlazarObservador(historial);
            notificar();
            this.nombre = NombreNuevo;
            this.correo = CorreoNuevo;
            this.contrasena = ContrasenaNueva;

        }

        originatorCliente.setEstado(cliente);
        caretaker.addMemento(originatorCliente.guardar());
    }

    /**
     * Muestra los datos de nombre, correo y contraseña en la pantalla de perfilUsuario
     */
    public void MostrarDatos() {
        NombreCompleto.setText(nombre);
        Correo.setText(correo);
        Contrasena.setText(contrasena);
    }

    /**
     * Guarda los nuevos datos de los clientes en el archivo txt
     */
    public void guardarDatos() {
        try {
            PerfilFachada perfilFachada = new PerfilFachada();
            perfilFachada.guardarDatos(this.clientes);
        } catch (Exception var13) {
            System.out.println(var13.getMessage());
        }
    }
}
