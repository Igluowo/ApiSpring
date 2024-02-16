package com.example.springproyecto.repository;

import com.example.springproyecto.model.ArtistsEntity;
import com.example.springproyecto.model.GenresEntity;
import org.springframework.data.repository.CrudRepository;

public interface GenresRepository extends CrudRepository<GenresEntity, Long> {

}
