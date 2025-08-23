package com.example.devops.mvc_demo.repository;

import com.example.devops.mvc_demo.domain.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepostory extends CrudRepository<Libro, Long> {
}
