package com.example.springproyecto.services;

import com.example.springproyecto.model.ArtistsEntity;
import com.example.springproyecto.repository.ArtistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ArtistsServices {
    @Autowired
    ArtistsRepository artistsRepository;

    public ArrayList<ArtistsEntity> getArtists() {
        return (ArrayList<ArtistsEntity>) artistsRepository.findAll();
    }

    public ArrayList<ArtistsEntity> getArtistsByName(String artist) {
        return artistsRepository.findByArtist(artist);
    }

    public Optional<ArtistsEntity> getArtistsById(Long id) {
        return artistsRepository.findById(id);
    }

    public ArtistsEntity postArtist(ArtistsEntity artists) {
        return artistsRepository.save(artists);
    }

    public boolean deleteArtist(Long id) {
        try {
            artistsRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
