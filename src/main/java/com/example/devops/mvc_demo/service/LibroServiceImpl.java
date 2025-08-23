package com.example.devops.mvc_demo.service;

import com.example.devops.mvc_demo.domain.Libro;
import com.example.devops.mvc_demo.repository.LibroRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("libroService")
public class LibroServiceImpl implements LibroService {
    private final LibroRepostory repostory;

    @Autowired
    public LibroServiceImpl(final LibroRepostory repostory) {
        this.repostory = repostory;
    }

    @Override
    public Iterable<Libro> findAll() {
        return repostory.findAll();
    }
}
