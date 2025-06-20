package com.biblioteca.model;

public abstract class Publicacion {
    private String titulo;
    private String autor;
    private int anio;
    private String codigoISBN;

    public Publicacion(String titulo, String autor, int anio, String codigoISBN) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.codigoISBN = codigoISBN;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }
    public String getCodigoISBN() { return codigoISBN; }

    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
    }

    public void mostrarInfo(boolean detallado) {
        mostrarInfo();
        if (detallado) {
            System.out.println("Autor: " + autor);
            System.out.println("Año: " + anio);
            System.out.println("ISBN: " + codigoISBN);
        }
    }
}
