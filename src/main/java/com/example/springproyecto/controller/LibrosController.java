package com.example.springproyecto.controller;

import com.example.springproyecto.model.AutoresEntity;
import com.example.springproyecto.model.LibrosEntity;
import com.example.springproyecto.services.AutoresServices;
import com.example.springproyecto.services.LibrosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibrosController {
    @Autowired
    LibrosServices librosServices;

    @Autowired
    AutoresServices autoresServices;

    @GetMapping()
    public ArrayList<LibrosEntity> getLibros() {
        return librosServices.getLibros();
    }

    @GetMapping(path = "/title/{libro}")
    public ArrayList<LibrosEntity> getLibroByName(@PathVariable("libro") String libros) {
        return librosServices.getLibrosByTitulo(libros);
    }

    @GetMapping(path = "/id/{libroid}")
    public Optional<LibrosEntity> getLibroById(@PathVariable("libroid") Long id) {
        return librosServices.getLibrosById(id);
    }

    @PostMapping()
    public LibrosEntity postLibros(@RequestBody LibrosEntity libros) {
        return this.librosServices.postLibro(libros);
    }

    @DeleteMapping(path = "/{librosid}")
    public String deleteLibrosById(@PathVariable("librosid") Long id) {
        boolean ok = autoresServices.deleteAutores(id);
        if (ok) {
            return "Deleted books with id " + id;
        }else{
            return "The books with id " + id + " could not be deleted";
        }
    }

    @PutMapping()
    public LibrosEntity putLibros(@RequestBody LibrosEntity libros) {
        return librosServices.postLibro(libros);
    }
}
