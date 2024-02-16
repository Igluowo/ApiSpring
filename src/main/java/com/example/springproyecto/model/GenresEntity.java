package com.example.springproyecto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "genres", schema = "pitchfork", catalog = "")
public class GenresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "genreid")
    private int genreid;
    @Basic
    @Column(name = "reviewid")
    private Integer reviewid;
    @Basic
    @Column(name = "genre")
    private String genre;

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public Object getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenresEntity that = (GenresEntity) o;

        if (genreid != that.genreid) return false;
        if (reviewid != null ? !reviewid.equals(that.reviewid) : that.reviewid != null) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = genreid;
        result = 31 * result + (reviewid != null ? reviewid.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
