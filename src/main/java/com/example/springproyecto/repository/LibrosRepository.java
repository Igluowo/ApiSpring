package com.example.springproyecto.repository;

import com.example.springproyecto.model.LibrosEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface LibrosRepository extends CrudRepository<LibrosEntity, Long> {

    public abstract ArrayList<LibrosEntity> findByTitulo(String titulo);
}
