package com.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.services.Biblioteca;

public class Usuario {
    private String id;
    private List<Publicacion> favoritos;

    public Usuario(String id) {
        this.id = id;
        this.favoritos = new ArrayList<>();
    }

    public List<Publicacion> buscarPorTitulo(String titulo) {
        return Biblioteca.buscarPublicaciones(titulo, null);
    }

    public List<Publicacion> buscarPorAutor(String autor) {
        return Biblioteca.buscarPublicaciones(null, autor);
    }

    public synchronized void marcarFavorito(Publicacion publicacion) {
        if (!favoritos.contains(publicacion)) {
            favoritos.add(publicacion);
            Biblioteca.actualizarEstadisticas();
        }
    }

    public List<Publicacion> getFavoritos() {
        return new ArrayList<>(favoritos);
    }

    public String getId() { return id; }
}
