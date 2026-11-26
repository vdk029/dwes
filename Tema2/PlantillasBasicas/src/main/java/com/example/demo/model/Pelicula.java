package com.example.demo.model;

import java.time.LocalDate;

public class Pelicula {

    private String titulo;
    private String genero;
    private double puntuacion;
    private String urlImdb;
    private String urlPortada;
    private LocalDate fechaEstreno;

    // Const vacio
    public Pelicula() {
    }

    // Constructor completo
    public Pelicula(String titulo, String genero,
                    double puntuacion, String urlImdb,
                    String urlPortada, LocalDate fechaEstreno) {

        this.titulo = titulo;
        this.genero = genero;
        this.puntuacion = puntuacion;
        this.urlImdb = urlImdb;
        this.urlPortada = urlPortada;
        this.fechaEstreno = fechaEstreno;
    }

    // GETTERS Y SETTERS

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getUrlImdb() {
        return urlImdb;
    }

    public void setUrlImdb(String urlImdb) {
        this.urlImdb = urlImdb;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }
}