package com.example.springproyecto.repository;

import com.example.springproyecto.model.AutoresEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;

@Repository
public interface AutoresRepository extends CrudRepository<AutoresEntity, Long> {
    public abstract ArrayList<AutoresEntity> findByNombreAutor(String autor);

    @Query("SELECT a.nacionalidad, GROUP_CONCAT(a.nombreAutor) FROM AutoresEntity a GROUP BY a.nacionalidad")
    ArrayList<Object[]> findAutoresGroupedByNacionalidad();
}
