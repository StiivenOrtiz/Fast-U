package com.fastu.fastu.persistencia;

import com.fastu.fastu.Util.Constantes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistroUsuario {
    public boolean registrarUsuario(String nombre, String correo, String contrasena) throws IOException {
        File archivo = new File(Constantes.nombreDatosClientes);
        if (archivo.exists()) {
            try {
                FileWriter escribir = new FileWriter(archivo, true);
                PrintWriter imprimir = new PrintWriter(escribir);
                imprimir.println(nombre + "," + correo + "," + contrasena);
                imprimir.close();
                escribir.close();
                return true;
            } catch (IOException ex) {
                System.out.println("No se pudo abrir el archivo datospersonales.txt!");
                ex.printStackTrace();
                throw ex;
            }
        } else {
            return crearArchivoDatosPersonales(archivo, nombre, correo, contrasena);
        }
    }

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
            System.out.println("No se crear el archivo datospersonales.txt!");
            ex.printStackTrace();
            throw ex;
        }
    }
}
