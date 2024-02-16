package com.example.springproyecto.services;

import com.example.springproyecto.model.ReviewsEntity;
import com.example.springproyecto.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewsServices {

    @Autowired
    ReviewsRepository reviewsRepository;


    public Page<ReviewsEntity> getReviews(Pageable pageable) {
        return reviewsRepository.findAll(pageable);
    }

    public Optional<ReviewsEntity> getReviewsById(Long id) {
        return reviewsRepository.findById(id);
    }

    public Page<ReviewsEntity> getReviewsFilterByScore(BigDecimal score, Pageable pageable) {
        return reviewsRepository.findByScoreGreaterThanEqual(score, pageable);
    }

    public Map<BigDecimal, List<ReviewsEntity>> getReviewsGroupedByScore() {
        List<ReviewsEntity> allReviews = (List<ReviewsEntity>) reviewsRepository.findAll();
        return allReviews.stream().collect(Collectors.groupingBy(ReviewsEntity::getScore));
    }
 }
