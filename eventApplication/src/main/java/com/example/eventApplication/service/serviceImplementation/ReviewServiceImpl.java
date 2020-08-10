package com.example.eventApplication.service.serviceImplementation;

import com.example.eventApplication.repository.ReviewRepository;
import com.example.eventApplication.model.Event;
import com.example.eventApplication.model.Review;
import com.example.eventApplication.model.User;
import com.example.eventApplication.security.service.UserSecurity;
import com.example.eventApplication.service.serviceInterface.EventService;
import com.example.eventApplication.service.serviceInterface.ReviewService;
import com.example.eventApplication.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * Review Service Implementation for the integration of business logic.
 *
 * @author Margarita Zargaryan
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Autowired
    public EventService eventService;

    @Autowired
    public UserService userService;

    @Autowired
    public UserSecurity userSecurity;

    /**
     * Post review for an event.
     */
    @Override
    public Optional<Review> postReviewById(Long eventId, Review review, String token) throws Exception {
        Event event = eventService.getEventById(eventId)
                .orElseThrow(() -> new Exception(("Event" + eventId + "not found")));
        String username = userSecurity.getUsernameFromToken(token);
        User user = userService.getByUsername(username)
                .orElseThrow(() -> new Exception(("User " + username + " not found")));
        review.setEvent(event);
        review.setUser(user);
        event.getReviews().add(review);
        return Optional.of(reviewRepository.save(review));
    }

    /**
     * Get reviews of an event.
     */
    @Override
    public Set<Review> getReviewsByEventId(Long eventId) throws Exception {
        Event event = eventService.getEventById(eventId)
                .orElseThrow(() -> new Exception(("Event" + eventId + "not found")));
        return event.getReviews();
    }

    /**
     * Get review by ID.
     */
    @Override
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    /**
     * Update review by ID.
     */
    @Override
    public Optional<Review> updateReviewById(Long reviewId, Review updatedReview) throws Exception {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new Exception(("Review" + reviewId + "not found")));
        review.setText(updatedReview.getText());
        return Optional.of(reviewRepository.save(review));
    }

    /**
     * Delete review by ID.
     */
    @Override
    public void deleteReviewById(Long reviewId, Long eventId) throws Exception {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new Exception(("Review" + reviewId + "not found")));
        Event article = eventService.getEventById(eventId)
                .orElseThrow(() -> new Exception(("Event" + eventId + "not found")));
        article.removeReview(review);
        reviewRepository.delete(review);
    }


}
