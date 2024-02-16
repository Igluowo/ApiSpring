package com.example.springproyecto.controller;

import com.example.springproyecto.model.ArtistsEntity;
import com.example.springproyecto.model.ReviewsEntity;
import com.example.springproyecto.repository.ArtistsRepository;
import com.example.springproyecto.services.ArtistsServices;
import com.example.springproyecto.services.ReviewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    ReviewsServices reviewsServices;

    @Autowired
    ArtistsServices artistsServices;

    @GetMapping()
    public Page<ReviewsEntity> getReviews(Pageable pageable) {
        return reviewsServices.getReviews(pageable);
    }

    @GetMapping("/filtered")
    public Page<ReviewsEntity> getReviewsFilterByScore(@RequestParam(name = "score",
            defaultValue = "0.0") BigDecimal score, Pageable pageable) {
        return reviewsServices.getReviewsFilterByScore(score, pageable);
    }

    @GetMapping("/grouped-score")
    public ResponseEntity<Map<BigDecimal, List<ReviewsEntity>>> getReviewsGroupedByScore() {
        Map<BigDecimal, List<ReviewsEntity>> groupedReviews = reviewsServices.getReviewsGroupedByScore();
        return new ResponseEntity<>(groupedReviews, HttpStatus.OK);
    }

}
