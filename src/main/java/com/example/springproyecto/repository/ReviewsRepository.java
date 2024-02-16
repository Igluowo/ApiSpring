package com.example.springproyecto.repository;

import com.example.springproyecto.model.ReviewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;

@Repository
public interface ReviewsRepository extends CrudRepository<ReviewsEntity, Long> {
    //public abstract ArrayList<ReviewsEntity> findByArtist(String artist);

    Page<ReviewsEntity> findAll(Pageable pageable);

    Page<ReviewsEntity> findByScoreGreaterThanEqual(BigDecimal score, Pageable pageable);

}
