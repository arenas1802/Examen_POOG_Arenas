package com.biblioteca.main;

import com.biblioteca.model.*;
import com.biblioteca.services.Biblioteca;

public class AppBiblioteca {
    public static void main(String[] args) {
        System.out.println("🌟 SISTEMA DE BIBLIOTECA INICIADO 🌟\n");
        
        // Crear y registrar publicaciones
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "978-0307474728");
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, "978-0156012195", "Fábula");
        Revista revista1 = Revista.crearRevistaDefault("National Geographic", 215);
        
        Biblioteca.registrarPublicacion(libro1);
        Biblioteca.registrarPublicacion(libro2);
        Biblioteca.registrarPublicacion(revista1);
        
        // Crear y registrar usuarios
        Usuario usuario1 = new Usuario("USR-001");
        Usuario usuario2 = new Usuario("USR-002");
        Biblioteca.registrarUsuario(usuario1);
        Biblioteca.registrarUsuario(usuario2);
        
        // Demostración de funcionalidades
        System.out.println("\n🔍 BUSQUEDA DE LIBROS:");
        System.out.println("Libros de García Márquez:");
        usuario1.buscarPorAutor("García").forEach(p -> p.mostrarInfo(true));
        
        System.out.println("\n❤️ MARCAR FAVORITOS:");
        usuario1.marcarFavorito(libro1);
        usuario1.marcarFavorito(revista1);
        usuario2.marcarFavorito(libro2);
        
        System.out.println("Usuario1 tiene " + usuario1.getFavoritos().size() + " favoritos");
        System.out.println("Usuario2 tiene " + usuario2.getFavoritos().size() + " favorito");
        
        System.out.println("\n📖 ESTIMACIÓN DE PALABRAS:");
        System.out.println(libro1.getTitulo() + ": " + libro1.calcularPalabras() + " palabras");
        System.out.println(libro2.getTitulo() + ": " + libro2.calcularPalabras() + " palabras");
        
        // Mostrar estadísticas
        Biblioteca.Estadisticas.mostrarEstadisticas();
        
        System.out.println("\n✅ SISTEMA OPERATIVO");
    }
}
