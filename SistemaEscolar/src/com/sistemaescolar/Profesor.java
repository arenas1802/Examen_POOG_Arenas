package com.sistemaescolar;

public class Profesor extends Persona {
    public Profesor(String nombre, int edad) {
        super(nombre, edad);
    }

    public void registrarAlumno(Curso curso, Alumno alumno) {
        curso.agregarAlumno(alumno);
    }

    public double consultarPromedio(Alumno alumno) {
        return alumno.calcularPromedio();
    }
}
