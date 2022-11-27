package com.fastu.fastu.Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    public String correoSolicitante;
    private Datos domiciliario;
    private ArrayList<Producto> productos;
    private String tienda;
    private String tipopago;
    private String estado; // 0 -> No realizado, 1 -> En preparación, 2 -> En trayecto, 3 -> Cancelado // 4 -> Entregado
    private float calificacion;
    private String fecha;

    public Pedido(Datos domiciliario, String estado, ArrayList<Producto> prodcutos, String tienda, float calificacion, Date fecha) {
        this.domiciliario = domiciliario;
        this.productos = prodcutos;
        this.tienda = tienda;
        this.calificacion = calificacion;
    }

    public Pedido(String fecha, String tipopago, String estado, String correoSolicitante) {
        this.fecha = fecha;
        this.tipopago = tipopago;
        this.estado = estado;
        this.correoSolicitante = correoSolicitante;
    }

    public Pedido(String fecha, String tipopago, String estado) {
        this.fecha = fecha;
        this.tipopago = tipopago;
        this.estado = estado;
    }


    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Datos getDomiciliario() {
        return domiciliario;
    }

    public void setDomiciliario(Datos domiciliario) {
        this.domiciliario = domiciliario;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> prodcutos) {
        this.productos = prodcutos;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getTipopago() {
        return tipopago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCorreoSolicitante() {
        return correoSolicitante;
    }

    public void setCorreoSolicitante(String correoSolicitante) {
        this.correoSolicitante = correoSolicitante;
    }

    public void setCosto(String tipopago) {
        this.tipopago = tipopago;
    }
}
