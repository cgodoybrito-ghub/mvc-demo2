package com.example.devops.mvc_demo.service;

import com.example.devops.mvc_demo.domain.Libro;

public interface LibroService {
    Iterable<Libro> findAll();
    Iterable<Libro> findByNombre(String nombre);
    Iterable<Libro> findByAutor(String autor);
}
