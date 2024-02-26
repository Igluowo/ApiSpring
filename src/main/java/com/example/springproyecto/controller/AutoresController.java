package com.example.springproyecto.controller;

import com.example.springproyecto.model.AutoresEntity;
import com.example.springproyecto.services.AutoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutoresController {
    @Autowired
    AutoresServices autoresServices;

    @GetMapping()
    public ArrayList<AutoresEntity> getAutores() {
        return autoresServices.getAutores();
    }

    @GetMapping(path = "/name/{autores}")
    public ArrayList<AutoresEntity> getByNombreAutor(@PathVariable("autores") String autores) {
        return autoresServices.getByNombreAutor(autores);
    }

    @GetMapping(path = "/id/{autoresid}")
    public Optional<AutoresEntity> getAutoresById(@PathVariable("autoresid") Long id) {
        return autoresServices.getAutoresById(id);
    }

    @GetMapping(path = "/grouped-nacionalidad")
    public Map<String, List<String>> getAutoresGroupedByNacionalidad() {
        return autoresServices.getAutoresGroupedByNacionalidad();
    }

    @PostMapping()
    public AutoresEntity postAutores(@RequestBody AutoresEntity autores) {
        return this.autoresServices.postAutores(autores);
    }

    @DeleteMapping(path = "/{autoresid}")
    public String deleteAutoresById(@PathVariable("autoresid") Long id) {
        boolean ok = autoresServices.deleteAutores(id);
        if (ok) {
            return "Deleted autor with id " + id;
        }else{
            return "The autor with id " + id + " could not be deleted";
        }
    }

    @PutMapping("/{autorid}")
    public AutoresEntity putAutores(@PathVariable("autorid") int autorId, @RequestBody AutoresEntity autores) {
        return autoresServices.putAutores(autores);
    }
}
