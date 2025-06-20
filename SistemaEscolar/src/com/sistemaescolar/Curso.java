package com.sistemaescolar;

import java.util.ArrayList;
import java.util.HashMap;

public class Curso {
    private String nombre;
    private ArrayList<Alumno> alumnos;
    public static int numCursos = 0;
    public static int numAlumnos = 0;
    
    public class Asistencia {
        private HashMap<Alumno, Boolean> asistencias;
        
        public Asistencia() {
            asistencias = new HashMap<>();
        }
        
        public void registrarAsistencia(Alumno alumno, boolean asistio) {
            asistencias.put(alumno, asistio);
        }
    }
    
    public Curso(String nombre) {
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
        numCursos++;
    }
    
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        numAlumnos++;
    }
    
    public double getPromedioClase() {
        double suma = 0;
        for (Alumno alumno : alumnos) {
            suma += alumno.calcularPromedio();
        }
        return alumnos.isEmpty() ? 0 : Math.round((suma / alumnos.size()) * 100.0) / 100.0;
    }
    
    public int getCantidadAprobados() {
        int aprobados = 0;
        for (Alumno alumno : alumnos) {
            if (alumno.calcularPromedio() >= 11) {
                aprobados++;
            }
        }
        return aprobados;
    }
}
