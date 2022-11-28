package com.fastu.fastu.persistencia;

import com.fastu.fastu.Modelo.Pedido;
import com.fastu.fastu.Util.Constantes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LecturaHistorial {
    public ArrayList<Pedido> leerHistorialPedidos(String correo) throws IOException {
        ArrayList<Pedido> datosObtenidos = new ArrayList<>();
        try (Scanner datosini = new Scanner(Paths.get(Constantes.nombreHistorial))) {
            System.out.println("Archivo abierto");
            while (datosini.hasNext()) {
                String linea = datosini.nextLine();
                String[] pedazo = linea.split(",");
                if (pedazo[3].equals(correo)) {
                    datosObtenidos.add(new Pedido(pedazo[0], pedazo[1], pedazo[2], pedazo[3]));
                }
            }
            return datosObtenidos;
        } catch (IOException e) {
            System.out.println("error al leer el archivo historial.txt");
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<Pedido> cargarHistorial() {
        Pedido objeto;
        ArrayList<Pedido> pedidos = new ArrayList();
        try {
            String linea = null;
            BufferedReader leerFichero = new BufferedReader(new FileReader(Constantes.nombreHistorial));
            while ((linea = leerFichero.readLine()) != null) {
                System.out.println(linea);
                StringTokenizer mistokens = new StringTokenizer(linea, ",");
                String fecha = mistokens.nextToken();
                String tipo = mistokens.nextToken();
                String estado = mistokens.nextToken();
                String correo = mistokens.nextToken();
                objeto = new Pedido(fecha, tipo, estado, correo);
                pedidos.add(objeto);
            }
            leerFichero.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pedidos;
    }
}
