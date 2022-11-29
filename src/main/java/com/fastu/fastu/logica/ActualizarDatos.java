package com.fastu.fastu.logica;

import com.fastu.fastu.Controladores.HistorialController;
import com.fastu.fastu.Controladores.PerfilUsuarioController;
import com.fastu.fastu.Controladores.RegistroController;
import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.Util.Constantes;
import com.fastu.fastu.observador.Observador;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase para manejar la actualización de datos desde el perfil del usuario
 */
public class ActualizarDatos {
    /**
     * Tokeniza el archivo de datospersonales en un nuevo arreglo de tipo Cliente
     *
     * @return
     */
    public ArrayList<Cliente> TokenizarArray() {
        Cliente objeto;
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            String linea = null;
            BufferedReader leerFichero = new BufferedReader(new FileReader(Constantes.nombreDatosClientes));
            while ((linea = leerFichero.readLine()) != null) {
                System.out.println(linea);
                StringTokenizer mistokens = new StringTokenizer(linea, ",");
                String nombre = mistokens.nextToken();
                String correo = mistokens.nextToken();
                String contrasena = mistokens.nextToken();
                objeto = new Cliente(nombre, correo, contrasena);
                clientes.add(objeto);
            }
            leerFichero.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    /**
     * Actualiza los datos del cliente
     *
     * @param clientes
     * @param nombre
     * @param NombreNuevo
     * @param correo
     * @param CorreoNuevo
     * @param contrasena
     * @param ContrasenaNueva
     * @return boolean, True si se cambiaron los datos, false de lo contrario
     */
    public boolean actualizarDatosEspecificos(ArrayList<Cliente> clientes, String nombre, String NombreNuevo, String correo, String CorreoNuevo, String contrasena, String ContrasenaNueva) {
        RegistroController registro = new RegistroController();
        HistorialController historial = new HistorialController();
        PerfilUsuarioController perfil = new PerfilUsuarioController();

        for (Cliente clients : clientes) {

            if ((clients.getNombreCompletos().equals(nombre) && !nombre.equals(NombreNuevo)) ||
                    (clients.getCorreo().equals(correo) && !correo.equals(CorreoNuevo)) ||
                    (clients.getContrasena().equals(contrasena) && !contrasena.equals(ContrasenaNueva))) {
                clients.setNombreCompleto(NombreNuevo);
                clients.setCorreo(CorreoNuevo);
                clients.setContrasena(ContrasenaNueva);
                registro.setNombre(NombreNuevo);
                registro.setCorreo(CorreoNuevo);
                registro.setPw(ContrasenaNueva);
                historial.setCorreoa(correo);
                perfil.enlazarObservador(historial);
                perfil.notificar();
                System.out.println("===========================Usuario========================================================================================================================================");
                System.out.println("El nuevo nombre es:" + clients.getNombreCompletos() + "\t" + "El nuevo correo es:" + clients.getCorreo() + "\t" + "La nueva contrasena:" + clients.getContrasena());
                return true;
            }
        }
        return false;
    }

    /**
     * guarda los datos nuevos en archivo txt nuevo
     *
     * @param clientes
     */
    public void guardarDatos(ArrayList<Cliente> clientes) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.nombreDatosClientes));
            clientes.forEach(n ->
            {
                try {
                    bw.write(n.getNombreCompletos() + "," + n.getCorreo() + "," + n.getContrasena() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.close();
            System.out.println("cerrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Notifica y realiza update a cada uno de los observadores existentes
     *
     * @param observadores, ArrayList de tipo Observador
     */
    public void notificar(ArrayList<Observador> observadores) {
        observadores.stream().forEach(o -> {
            o.update();
        });
    }
}
