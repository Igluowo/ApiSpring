package com.example.springproyecto.controller;

import com.example.springproyecto.model.ArtistsEntity;
import com.example.springproyecto.services.ArtistsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/artist")
public class ArtistsController {
    @Autowired
    ArtistsServices artistsServices;

    @GetMapping()
    public ArrayList<ArtistsEntity> getArtists() {
        return artistsServices.getArtists();
    }

    @GetMapping(path = "/{artist}")
    public ArrayList<ArtistsEntity> getArtistsByName(@PathVariable("artist") String artist) {
        return artistsServices.getArtistsByName(artist);
    }

    @GetMapping(path = "/{artistid}")
    public ArrayList<ArtistsEntity> getArtistsById(@PathVariable("artistid") String artist) {
        return artistsServices.getArtistsByName(artist);
    }

    @PostMapping()
    public ArtistsEntity postArtists(@RequestBody ArtistsEntity artist) {
        return this.artistsServices.postArtist(artist);
    }

    @DeleteMapping(path = "/{artistid}")
    public String deleteArtistById(@PathVariable("artistid") Long id) {
        boolean ok = artistsServices.deleteArtist(id);
        if (ok) {
            return "Deleted artist with id " + id;
        }else{
            return "The artist with id " + id + " could not be deleted";
        }
    }

    @PutMapping()
    public ArtistsEntity putArtist(@RequestBody ArtistsEntity artist) {
        return artistsServices.postArtist(artist);
    }
}
