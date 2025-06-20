package com.biblioteca.services;

import java.util.ArrayList;
import java.util.List;
import com.biblioteca.model.*;

public class Biblioteca {
    private static List<Publicacion> publicaciones = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();

    public static class Estadisticas {
        public static double promedioPalabrasLibros() {
            if (publicaciones.isEmpty()) return 0.0;
            
            int totalLibros = 0;
            int sumaPalabras = 0;
            
            for (Publicacion pub : publicaciones) {
                if (pub instanceof Libro) {
                    sumaPalabras += ((Libro) pub).calcularPalabras();
                    totalLibros++;
                }
            }
            
            return totalLibros > 0 ? (double) sumaPalabras / totalLibros : 0.0;
        }

        public static int totalLibrosFavoritos() {
            int total = 0;
            for (Usuario user : usuarios) {
                for (Publicacion fav : user.getFavoritos()) {
                    if (fav instanceof Libro) {
                        total++;
                    }
                }
            }
            return total;
        }

        public static void mostrarEstadisticas() {
            System.out.println("\n=== ESTADÍSTICAS ===");
            System.out.printf("Total publicaciones: %d\n", publicaciones.size());
            System.out.printf("Libros: %d | Revistas: %d\n", 
                contarTipo(Libro.class), contarTipo(Revista.class));
            System.out.printf("Promedio palabras por libro: %.2f\n", promedioPalabrasLibros());
            System.out.println("Total libros favoritos: " + totalLibrosFavoritos());
        }

        private static int contarTipo(Class<?> tipo) {
            return (int) publicaciones.stream()
                   .filter(tipo::isInstance)
                   .count();
        }
    }

    public static void registrarPublicacion(Publicacion publicacion) {
        if (!publicaciones.contains(publicacion)) {
            publicaciones.add(publicacion);
        }
    }

    public static void registrarUsuario(Usuario usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    public static List<Publicacion> buscarPublicaciones(String titulo, String autor) {
        List<Publicacion> resultados = new ArrayList<>();
        for (Publicacion pub : publicaciones) {
            boolean matchTitulo = titulo == null || pub.getTitulo().contains(titulo);
            boolean matchAutor = autor == null || pub.getAutor().contains(autor);
            
            if (matchTitulo && matchAutor) {
                resultados.add(pub);
            }
        }
        return resultados;
    }

    public static void actualizarEstadisticas() {
        // Lógica para actualizar estadísticas si fuera necesario
    }
}
