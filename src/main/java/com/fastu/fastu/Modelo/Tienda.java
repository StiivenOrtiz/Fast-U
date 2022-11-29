package com.fastu.fastu.Modelo;

import java.util.ArrayList;

public class Tienda extends Datos {
    private final ArrayList<Producto> productos;
    private String dueno;
    private String nombreTienda;
    private float calificacion;
    private float costoEnvio;
    private float tiempoEntrega;
    private String imagenTienda;
    private String tipoTienda;

    /**
     * Constructor de Tienda
     *
     * @param nombresCompletos
     * @param correo
     * @param contrasena
     * @param dueno
     * @param nombreTienda
     * @param imagenTienda
     * @param tipoTienda
     */
    public Tienda(String nombresCompletos, String correo, String contrasena, String dueno, String nombreTienda, String imagenTienda, String tipoTienda) {
        super(nombresCompletos, correo, contrasena);
        this.dueno = dueno;
        this.nombreTienda = nombreTienda;
        this.imagenTienda = imagenTienda;
        this.calificacion = 0;
        this.costoEnvio = 0;
        this.tiempoEntrega = 0;
        this.tipoTienda = tipoTienda;
        this.productos = new ArrayList<Producto>();
    }

    public Tienda(String tipoTienda, String correo, String nombreTienda, float calificacion, float costoEnvio, float tiempoEntrega, String imagenTienda) {
        super("", correo, "");
        this.dueno = correo;
        this.nombreTienda = nombreTienda;
        this.imagenTienda = imagenTienda;
        this.calificacion = calificacion;
        this.costoEnvio = costoEnvio;
        this.tiempoEntrega = tiempoEntrega;
        this.tipoTienda = tipoTienda;
        this.productos = new ArrayList<Producto>();
    }

    public Tienda(String nombresCompletos, String correo, String contrasena, String dueno, String nombreTienda, String tipoTienda, ArrayList<Producto> productos) {
        super(nombresCompletos, correo, contrasena);
        this.dueno = dueno;
        this.nombreTienda = nombreTienda;
        this.calificacion = 0;
        this.costoEnvio = 0;
        this.tiempoEntrega = 0;
        this.productos = productos;
        this.tipoTienda = tipoTienda;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos.clear();
        this.productos.addAll(productos);
    }

    public float getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(float tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public float getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(float costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public String getImagenTienda() {
        return imagenTienda;
    }

    public void setImagenTienda(String imagenTienda) {
        this.imagenTienda = imagenTienda;
    }

    public String getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(String tipoTienda) {
        this.tipoTienda = tipoTienda;
    }
}
