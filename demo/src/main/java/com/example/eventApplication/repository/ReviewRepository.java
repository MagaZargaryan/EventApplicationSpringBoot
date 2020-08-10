package com.example.eventApplication.repository;

import com.example.eventApplication.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Override
    Optional<Review> findById(Long aLong);
}
