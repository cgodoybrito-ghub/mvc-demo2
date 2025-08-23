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

            final List<Libro> libros = new ArrayList<>();
            libros.add(libro1);

            repostory.saveAll(libros);
        }
    }
}
