package com.example.eventApplication.service.serviceInterface;

import com.example.eventApplication.model.Review;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * Interface for Review Service.
 *
 * @author Margarita Zargaryan
 */
@Service
public interface ReviewService {
    public Optional<Review> postReviewById(Long eventId, Review review, String token) throws Exception;

    public Set<Review> getReviewsByEventId(Long eventId) throws Exception;

    public Optional<Review> getReviewById(Long reviewId);

    public Optional<Review> updateReviewById(Long reviewId, Review updatedReview) throws Exception;

    public void deleteReviewById(Long reviewId, Long eventId) throws Exception;

}
