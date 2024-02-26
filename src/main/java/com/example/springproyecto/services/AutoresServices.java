package com.example.springproyecto.services;

import com.example.springproyecto.model.AutoresEntity;
import com.example.springproyecto.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AutoresServices {
    @Autowired
    AutoresRepository autoresRepository;

    public ArrayList<AutoresEntity> getAutores() {
        return (ArrayList<AutoresEntity>) autoresRepository.findAll();
    }

    public ArrayList<AutoresEntity> getByNombreAutor(String autores) {
        return autoresRepository.findByNombreAutor(autores);
    }

    public Map<String, List<String>> getAutoresGroupedByNacionalidad() {
        ArrayList<Object[]> resultados = autoresRepository.findAutoresGroupedByNacionalidad();

        Map<String, List<String>> autoresAgrupados = new HashMap<>();

        for (Object[] resultado : resultados) {
            String nacionalidad = (String) resultado[0];
            String nombresConcatenados = (String) resultado[1];
            List<String> nombresAutores = List.of(nombresConcatenados.split(","));

            autoresAgrupados.put(nacionalidad, nombresAutores);
        }
        return autoresAgrupados;
    }

    public Optional<AutoresEntity> getAutoresById(Long id) {
        return autoresRepository.findById(id);
    }

    public AutoresEntity postAutores(AutoresEntity autores) {
        return autoresRepository.save(autores);
    }

    public boolean deleteAutores(Long id) {
        try {
            autoresRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public AutoresEntity putAutores(AutoresEntity autores) {
        Optional<AutoresEntity> existingAutor = autoresRepository.findById((long) autores.getIdAutor());
        if (existingAutor.isPresent()) {
            AutoresEntity updatedAutor = existingAutor.get();
            updatedAutor.setNombreAutor(autores.getNombreAutor());
            updatedAutor.setNacionalidad(autores.getNacionalidad());
            updatedAutor.setImagenUrl(autores.getImagenUrl());
            return autoresRepository.save(updatedAutor);
        } else {
            return autoresRepository.save(autores);
        }
    }
}
