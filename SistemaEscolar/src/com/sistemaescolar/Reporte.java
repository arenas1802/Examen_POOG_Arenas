package com.sistemaescolar;

public class Reporte {
    public static void mostrarPromedioGeneral(Curso curso) {
        System.out.println("Promedio general del curso: " + curso.getPromedioClase());
    }
    
    public static void mostrarAprobados(Curso curso) {
        System.out.println("Cantidad de aprobados: " + curso.getCantidadAprobados());
    }
}
