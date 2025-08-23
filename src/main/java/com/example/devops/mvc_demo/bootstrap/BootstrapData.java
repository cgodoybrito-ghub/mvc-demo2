package com.example.devops.mvc_demo.bootstrap;

import com.example.devops.mvc_demo.domain.Libro;
import com.example.devops.mvc_demo.domain.LibroCategoria;
import com.example.devops.mvc_demo.repository.LibroRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {
    private final LibroRepostory repostory;

    @Autowired
    public BootstrapData(final LibroRepostory repostory) {
        this.repostory = repostory;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repostory.count() == 0) {
            final Libro libro1 = new Libro(null, "The Phoenix Project", "Gene Kim", "978-1942788294", "It Revolution Pr", List.of(LibroCategoria.COMPUTACION, LibroCategoria.TECNOLOGIA));
            final Libro libro2 = new Libro(null, "The Demon-Haunted World", "Carl Sagan", "978-0345409461", "Ballantine Books", List.of(LibroCategoria.CIENCIA, LibroCategoria.FILOSOFIA));
            final Libro libro3 = new Libro(null, "I, Robot", "Isaac Asimov", "978-0553382563", "Del Rey", List.of(LibroCategoria.CIENCIA_FICCION));
            final Libro libro4 = new Libro(null, "Mi nombre es Emilia del Valle", "Isabel Allende", "978-8401035258", "PLAZA & JANÉS", List.of(LibroCategoria.FICCION, LibroCategoria.ROMANCE));
            final Libro libro5 = new Libro(null, "La casa de los espíritus", "Isabel Allende", "978-8401342585", "PLAZA & JANÉS", List.of(LibroCategoria.FICCION));
            final Libro libro6 = new Libro(null, "The Gods Themselves", "Isaac Asimov", "978-0307792389", "Spectra", List.of(LibroCategoria.CIENCIA_FICCION));

            final List<Libro> libros = new ArrayList<>();
            libros.add(libro1);
            libros.add(libro2);
            libros.add(libro3);
            libros.add(libro4);
            libros.add(libro5);
            libros.add(libro6);

            repostory.saveAll(libros);
        }
    }
}
