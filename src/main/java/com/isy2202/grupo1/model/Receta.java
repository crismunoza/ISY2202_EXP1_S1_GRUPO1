package com.isy2202.grupo1.model;

public class Receta {
    private String id; 
    private String titulo;
    private String descripcion;
    private String imagenUrl;
    private String tiempoPreparacion;
    private String pasos;

    public Receta() {}

    public Receta(String titulo, String descripcion, String imagenUrl, String tiempoPreparacion, String pasos) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.tiempoPreparacion = tiempoPreparacion;
        this.pasos = pasos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(String tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }
}
