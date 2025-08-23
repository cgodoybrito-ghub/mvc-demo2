package com.example.devops.mvc_demo.repository;

import com.example.devops.mvc_demo.domain.Libro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibroRepostory extends CrudRepository<Libro, Long> {
    List<Libro> findByNombreContaining(String nombre);
    List<Libro> findByAutorContaining(String autor);
}
