package com.example.springproyecto.repository;

import com.example.springproyecto.model.ArtistsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ArtistsRepository extends CrudRepository<ArtistsEntity, Long> {
    public abstract ArrayList<ArtistsEntity> findByArtist(String artist);
}
