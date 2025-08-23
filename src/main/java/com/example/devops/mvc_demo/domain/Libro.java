package com.example.devops.mvc_demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String autor;
    private String isb;
    private String editorial;
    private List<LibroCategoria> categorias;

    public Libro() {
    }

    public Libro(final Long id, final String nombre, final String autor, final String isb, final String editorial,
                 final List<LibroCategoria> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.isb = isb;
        this.editorial = editorial;
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(final String autor) {
        this.autor = autor;
    }

    public String getIsb() {
        return isb;
    }

    public void setIsb(final String isb) {
        this.isb = isb;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(final String editorial) {
        this.editorial = editorial;
    }

    public List<LibroCategoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(final List<LibroCategoria> categorias) {
        this.categorias = categorias;
    }
}
