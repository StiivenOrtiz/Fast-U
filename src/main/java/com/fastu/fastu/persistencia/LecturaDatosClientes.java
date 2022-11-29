package com.fastu.fastu.persistencia;

import com.fastu.fastu.Controladores.RegistroController;
import com.fastu.fastu.Util.Constantes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LecturaDatosClientes {

    /**
     * Busca el usuario en el archivo de datos personales por Usuario y contraseña
     *
     * @param correo
     * @param contrasena
     * @return Booleano, en caso de true significa que encontró el usuario y contraseña ingresados, de lo contrario un false que indica que no se encontró
     * @throws IOException
     */
    public boolean buscarCliente(String correo, String contrasena) throws IOException {
        boolean encontrado = false;
        BufferedReader lector;
        String linea;
        String[] partes = null;
        try {
            lector = new BufferedReader(new FileReader(Constantes.nombreDatosClientes));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(","); //separador
                String nombre = partes[0]; //se asigna el nombre
                String correoArch = partes[1]; //se asigna el correo
                String contrasenArch = partes[2]; //se asigna la contraseña
                RegistroController registro = new RegistroController();
                registro.setNombre(nombre);
                registro.setCorreo(correoArch);
                registro.setPw(contrasenArch);
                if (correo.equals(correoArch) && contrasena.equals(contrasenArch)) {
                    lector.close();
                    encontrado = true;
                    return encontrado;
                }
            }
            lector.close();
        } catch (IOException e) {

            System.out.println("error al leer el archivo datospersonales.txt");
            e.printStackTrace();
            throw e;
        }
        return encontrado;
    }

    /**
     * Busca el correo entre el archivo.
     *
     * @param correo
     * @return booleano que menciona si el correo fue encontrado o no.
     * @throws IOException
     */
    public boolean buscarCorreo(String correo) throws IOException {
        boolean encontrado = false;
        BufferedReader lector;
        String linea;
        String[] partes;
        try {
            lector = new BufferedReader(new FileReader(Constantes.nombreDatosClientes));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(","); //separador
                String correoArch;
                if (!partes[1].isEmpty()) {
                    correoArch = partes[1]; //se asigna el correo
                    if (correo.equals(correoArch)) {
                        encontrado = true; // nokas, porque no cierra el archivo :V
                        lector.close();
                        return encontrado;
                    }
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("error al leer el archivo datospersonales.txt");
            e.printStackTrace();
            throw e;
        }
        return encontrado;
    }

}
