package com.example.springproyecto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artists", schema = "pitchfork", catalog = "")
public class ArtistsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "artistid")
    private int artistid;
    @Basic
    @Column(name = "reviewid")
    private Integer reviewid;
    @Basic
    @Column(name = "artist")
    private String artist;

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    public Object getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistsEntity that = (ArtistsEntity) o;

        if (artistid != that.artistid) return false;
        if (reviewid != null ? !reviewid.equals(that.reviewid) : that.reviewid != null) return false;
        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = artistid;
        result = 31 * result + (reviewid != null ? reviewid.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        return result;
    }
}
