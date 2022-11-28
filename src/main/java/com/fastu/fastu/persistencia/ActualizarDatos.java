package com.fastu.fastu.persistencia;

import com.fastu.fastu.Controladores.HistorialController;
import com.fastu.fastu.Controladores.PerfilUsuarioController;
import com.fastu.fastu.Controladores.RegistroController;
import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.Util.Constantes;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ActualizarDatos {
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
     * guarda los da
     * @param clientes
     */
    public void guardarDatos(ArrayList<Cliente> clientes) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.nombreDatosClientes));
            Iterator iterador = clientes.iterator();
            while (iterador.hasNext()) {
                Cliente n = (Cliente) iterador.next();
                bw.write(n.getNombreCompletos() + "," + n.getCorreo() + "," + n.getContrasena() + "\n");
            }
            bw.close();
            System.out.println("cerrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
