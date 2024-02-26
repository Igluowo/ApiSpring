package com.example.springproyecto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Autores", schema = "libreria", catalog = "")
public class AutoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_autor")
    private int idAutor;
    @Basic
    @Column(name = "nombre_autor")
    private String nombreAutor;
    @Basic
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic
    @Column(name = "imagen_url")
    private String imagenUrl;

    @OneToMany(mappedBy = "idAutor", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<LibrosEntity> libros;

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public List<LibrosEntity> getLibros() {
        return libros;
    }

    public void setLibros(List<LibrosEntity> libros) {
        this.libros = libros;
    }

    public String addLibro(LibrosEntity libro) {
        try {
            if (libros == null) {
                libros = new ArrayList<>();
            }
            libros.add(libro);
            libro.setIdAutor(this);
            return "Se ha añadido un nuevo libro exitosamente";
        }catch (Exception e) {
            return "Ha habido un error al añadir el libro";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoresEntity that = (AutoresEntity) o;

        if (idAutor != that.idAutor) return false;
        if (nombreAutor != null ? !nombreAutor.equals(that.nombreAutor) : that.nombreAutor != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(that.nacionalidad) : that.nacionalidad != null) return false;
        if (imagenUrl != null ? !imagenUrl.equals(that.imagenUrl) : that.imagenUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAutor;
        result = 31 * result + (nombreAutor != null ? nombreAutor.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (imagenUrl != null ? imagenUrl.hashCode() : 0);
        return result;
    }
}
