package com.example.devops.mvc_demo.controller;

import com.example.devops.mvc_demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("libros/")
public class LibroController {
    private final LibroService service;

    @Autowired
    public LibroController(final LibroService service) {
        this.service = service;
    }


    @RequestMapping("listar")
    public String listarLibros(final Model model) {
        System.out.println("listar...");
        model.addAttribute("libros", service.findAll());
        return "libros";
    }
}
