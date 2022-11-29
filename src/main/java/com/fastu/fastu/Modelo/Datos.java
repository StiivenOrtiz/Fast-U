package com.fastu.fastu.Modelo;

public abstract class Datos {
    private String nombreCompleto = "";
    private String correo = "";
    private String contrasena = "";

    /**
     * Constructo Datos
     *
     * @param nombreCompleto
     * @param correo
     * @param contrasena
     */
    Datos(String nombreCompleto, String correo, String contrasena) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Datos() {

    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreCompletos() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
