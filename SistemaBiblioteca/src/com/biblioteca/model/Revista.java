package com.biblioteca.model;

public class Revista extends Publicacion {
    private int numero;

    public Revista(String titulo, String autor, int anio, String codigoISBN, int numero) {
        super(titulo, autor, anio, codigoISBN);
        this.numero = numero;
    }

    public static Revista crearRevistaDefault(String titulo, int numero) {
        return new Revista(titulo, "Editorial ABC", 2023, "REV-" + numero, numero);
    }

    @Override
    public void mostrarInfo(boolean detallado) {
        super.mostrarInfo(detallado);
        if (detallado) {
            System.out.println("Número: " + numero);
        }
    }

    public int getNumero() { return numero; }
}
