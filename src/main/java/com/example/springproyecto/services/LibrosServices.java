package com.example.springproyecto.services;

import com.example.springproyecto.model.AutoresEntity;
import com.example.springproyecto.model.LibrosEntity;
import com.example.springproyecto.repository.AutoresRepository;
import com.example.springproyecto.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class LibrosServices {

    @Autowired
    LibrosRepository librosRepository;

    @Autowired
    AutoresRepository autoresRepository;

    public ArrayList<LibrosEntity> getLibros() {
        return (ArrayList<LibrosEntity>) librosRepository.findAll();
    }

    public ArrayList<LibrosEntity> getLibrosByTitulo(String titulo) {
        return librosRepository.findByTitulo(titulo);
    }

    public Optional<LibrosEntity> getLibrosById(Long id) {return librosRepository.findById(id);}

    public LibrosEntity postLibro(LibrosEntity libro) {
        return librosRepository.save(libro);
    }

    public boolean deleteLibro(Long id) {
        try {
            librosRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public void asociarAutorALibro(Long libroId, Long autorId) {
        LibrosEntity libro = librosRepository.findById(libroId).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        AutoresEntity autor = autoresRepository.findById(autorId).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        autor.addLibro(libro);
        librosRepository.save(libro);
    }

    public void desasociarAutorALibro(Long libroId, Long autorId) {
        LibrosEntity libro = librosRepository.findById(libroId).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libro.removeAutor(libro);
        librosRepository.delete(libro);
    }
 }
