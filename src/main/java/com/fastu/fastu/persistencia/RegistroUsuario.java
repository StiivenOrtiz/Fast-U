package com.fastu.fastu.persistencia;

import com.fastu.fastu.Util.Constantes;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistroUsuario {
    /**
     * Registra un usuario nuevo con los parametros recibidos en el archivo de texto
     *
     * @param nombre
     * @param correo
     * @param contrasena
     * @return el estado del usuario registrado, true para confirmar el registro en el txt, false para lo contrario
     * @throws IOException
     */
    public boolean registrarUsuario(String nombre, String correo, String contrasena) throws IOException {
        boolean registrado = false;
        File archivo = new File(Constantes.nombreDatosClientes);
        if (archivo.exists()) {
            try {
                LecturaDatosClientes lecturaDatosClientes = new LecturaDatosClientes();
                if (!lecturaDatosClientes.buscarCorreo(correo) && correo.endsWith(Constantes.correoJaveriana)) {
                    FileWriter escribir = new FileWriter(archivo, true);
                    PrintWriter imprimir = new PrintWriter(escribir);
                    imprimir.println(nombre + "," + correo + "," + contrasena);
                    imprimir.close();
                    escribir.close();
                    registrado = true;
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("ERROR CORREO");
                    alert.setHeaderText("Correo no valido!");
                    alert.show();
                }
            } catch (IOException ex) {
                System.out.println("No se pudo abrir el archivo " + Constantes.nombreDatosClientes + "!");
                ex.printStackTrace();
                throw ex;
            }
        } else
            return crearArchivoDatosPersonales(archivo, nombre, correo, contrasena);
        return registrado;
    }

    /**
     * Crea el archivo de datospersonales.txt en caso de que este no exista y registra los usuarios
     *
     * @param archivo
     * @param nombre
     * @param correo
     * @param contrasena
     * @return true para confirmar que se pudo crear el archivo de los datos de los clientes, false lo contrario
     * @throws IOException
     */
    private boolean crearArchivoDatosPersonales(File archivo, String nombre, String correo, String contrasena) throws IOException {
        try {
            archivo.createNewFile();
            FileWriter escribir = new FileWriter(archivo, true);
            PrintWriter imprimir = new PrintWriter(escribir);
            imprimir.println(nombre + "," + correo + "," + contrasena);
            imprimir.close();
            escribir.close();
            return true;
        } catch (IOException ex) {
            System.out.println("No se crear el archivo " + Constantes.nombreDatosClientes + "!");
            ex.printStackTrace();
            throw ex;
        }
    }
}
