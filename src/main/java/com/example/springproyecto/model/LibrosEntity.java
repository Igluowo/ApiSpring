package com.example.springproyecto.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Libros", schema = "libreria", catalog = "")
public class LibrosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_libro")
    private int idLibro;
    @Basic
    @Column(name = "titulo")
    private String titulo;
    @Basic
    @Column(name = "año_publicacion")
    private Integer añoPublicacion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    @JsonManagedReference
    private AutoresEntity idAutor;
    @Basic
    @Column(name = "imagen_url")
    private String imagenUrl;

    public String removeAutor(LibrosEntity libro) {
        try {
            idAutor.getLibros().remove(libro);
            this.setIdAutor(null);
            return "Se ha desasociado el libro exitosamente";
        }catch (Exception e) {
            return "Ha habido un error al desasociar el libro";
        }
    }

    public long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(Integer añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public AutoresEntity getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(AutoresEntity idAutor) {
        this.idAutor = idAutor;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibrosEntity that = (LibrosEntity) o;

        if (idLibro != that.idLibro) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (añoPublicacion != null ? !añoPublicacion.equals(that.añoPublicacion) : that.añoPublicacion != null)
            return false;
        if (idAutor != null ? !idAutor.equals(that.idAutor) : that.idAutor != null) return false;
        if (imagenUrl != null ? !imagenUrl.equals(that.imagenUrl) : that.imagenUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long result = idLibro;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (añoPublicacion != null ? añoPublicacion.hashCode() : 0);
        result = 31 * result + (idAutor != null ? idAutor.hashCode() : 0);
        result = 31 * result + (imagenUrl != null ? imagenUrl.hashCode() : 0);
        return (int) result;
    }
}
