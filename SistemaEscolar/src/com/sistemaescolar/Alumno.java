package com.sistemaescolar;

import java.util.ArrayList;

public class Alumno extends Persona implements Cloneable {
    private ArrayList<Double> calificaciones;

    public Alumno(String nombre, int edad) {
        super(nombre, edad);
        this.calificaciones = new ArrayList<>();
    }

    public void agregarNota(double nota) {
        calificaciones.add(nota);
    }

    public void agregarNotas(double[] notas) {
        for (double nota : notas) {
            calificaciones.add(nota);
        }
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        return calificaciones.isEmpty() ? 0 : Math.round((suma / calificaciones.size()) * 100.0) / 100.0;
    }
    
    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Alumno cloned = (Alumno) super.clone();
        cloned.calificaciones = (ArrayList<Double>) this.calificaciones.clone();
        return cloned;
    }
}
