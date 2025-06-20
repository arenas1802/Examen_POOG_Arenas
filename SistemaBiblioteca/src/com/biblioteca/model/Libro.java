package com.biblioteca.model;

import java.util.Random;

public class Libro extends Publicacion {
    private String genero;

    public Libro(String titulo, String autor, int anio, String codigoISBN) {
        super(titulo, autor, anio, codigoISBN);
    }

    public Libro(String titulo, String autor, int anio, String codigoISBN, String genero) {
        super(titulo, autor, anio, codigoISBN);
        this.genero = genero;
    }

    public int calcularPalabras() {
        return (int) (Math.random() * 1000) + 100; // Entre 100 y 1100 palabras
    }

    @Override
    public void mostrarInfo(boolean detallado) {
        super.mostrarInfo(detallado);
        if (detallado && genero != null) {
            System.out.println("Género: " + genero);
        }
    }

    public String getGenero() { return genero; }
}
