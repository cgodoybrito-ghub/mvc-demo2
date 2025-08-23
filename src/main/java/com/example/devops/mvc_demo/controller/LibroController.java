package com.example.devops.mvc_demo.controller;

import com.example.devops.mvc_demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("libros/")
public class LibroController {
    private static final String STR_LIBROS = "libros";

    private final LibroService service;

    @Autowired
    public LibroController(final LibroService service) {
        this.service = service;
    }

    @RequestMapping("inicio")
    public String inicio(final Model model) {
        return "inicio";
    }

    @RequestMapping("buscarTitulo")
    public String buscarTitulo(final Model model, @RequestParam("titulo") final String titulo) {
        model.addAttribute(STR_LIBROS, service.findByNombre(titulo));
        return STR_LIBROS;
    }

    @RequestMapping("buscarAutor")
    public String buscarAutor(final Model model, @RequestParam("autor") final String autor) {
        model.addAttribute(STR_LIBROS, service.findByAutor(autor));
        return STR_LIBROS;
    }
}
