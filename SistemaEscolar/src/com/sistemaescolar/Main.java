package com.sistemaescolar;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Crear cursos
        Curso matematicas = new Curso("Matemáticas");
        Curso historia = new Curso("Historia");
        Curso ciencias = new Curso("Ciencias");
        
        // Crear profesor
        Profesor profesor = new Profesor("Carlos García", 42);
        
        // Crear alumnos con notas aleatorias
        Random rand = new Random();
        String[] nombres = {"Ana", "Luis", "María", "Pedro", "Sofía"};
        
        for (String nombre : nombres) {
            Alumno alumno = new Alumno(nombre, 17 + rand.nextInt(5));
            
            // Agregar 5 notas aleatorias entre 0 y 20
            double[] notas = new double[5];
            for (int i = 0; i < notas.length; i++) {
                notas[i] = Math.round(rand.nextDouble() * 20 * 10) / 10.0;
            }
            alumno.agregarNotas(notas);
            
            // Registrar alumnos en diferentes cursos
            profesor.registrarAlumno(matematicas, alumno);
            // Crear un nuevo objeto Alumno para historia
            Alumno alumnoHistoria = new Alumno(alumno.getNombre(), alumno.getEdad());
            alumnoHistoria.agregarNotas(notas);
            profesor.registrarAlumno(historia, alumnoHistoria);
        }
        
        // Generar reportes
        System.out.println("REPORTE DEL SISTEMA ESCOLAR");
        System.out.println("============================");
        System.out.println("Total cursos creados: " + Curso.numCursos);
        System.out.println("Total alumnos registrados: " + Curso.numAlumnos);
        System.out.println("\nEstadísticas para Matemáticas:");
        Reporte.mostrarPromedioGeneral(matematicas);
        Reporte.mostrarAprobados(matematicas);
    }
}
