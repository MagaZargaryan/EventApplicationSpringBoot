package com.example.eventApplication.controller;

import com.example.eventApplication.repository.EventRepository;
import com.example.eventApplication.repository.ReviewRepository;
import com.example.eventApplication.service.serviceImplementation.EventServiceImpl;
import com.example.eventApplication.service.serviceImplementation.ReviewServiceImpl;
import com.example.eventApplication.service.serviceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Review Rest controller class file for request handling and execution of CRUD operations.
 *
 * @author Margarita Zargaryan
 */
@RequestMapping("api/users")
@RestController
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    EventServiceImpl eventService;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    AuthenticationController authenticationAPI;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }


    /**
     * Handle post request to post review for an event.
     */
//    @MessageMapping("/{id}/events/{event_id}/reviews/new")
//    public ResponseEntity<?> postReviewByEventId(@RequestHeader("Authorization") String token,
//                                                 @DestinationVariable (value = "event_id") Long eventId,
//                                                 @Validated @RequestBody Review response) throws Exception {
//
//        Review review = reviewService.postReviewById(eventId, response, token)
//                .orElseThrow(() -> new Exception("Review is not posted."));
//        return ResponseEntity.ok().body(review);
//    }
//
//    /**
//     * Handle get request to get reviews of an event.
//     */
//    @SubscribeMapping("/{id}/events/{event_id}/reviews")
//    public ResponseEntity<?> getReviewByEventId(@DestinationVariable("event_id") Long eventId,
//                                                @DestinationVariable("id") String id) throws Exception {
//        Set<Review> reviews = reviewService.getReviewsByEventId(eventId);
//        return ResponseEntity.ok().body(reviews);
//    }
//
//    /**
//     * Handle get request to get a review by ID.
//     */
//    @GetMapping("/{id}/events/{event_id}/reviews/{review_id}")
//    public ResponseEntity<?> getReviewByReviewId(@PathVariable("event_id") Long eventId,
//                                                 @PathVariable("review_id") Long reviewId,
//                                                 @PathVariable("id") String id) throws Exception {
//        Review review = reviewService.getReviewById(reviewId)
//                .orElseThrow(() -> new Exception("Review not found"));
//        return ResponseEntity.ok().body(review);
//    }
//
//    /**
//     * Handle put request to update review by ID.
//     * Allow editing reviews only to review creators and admins.
//     */
//    @PutMapping("/{id}/events/{event_id}/reviews/{review_id}")
//    @PreAuthorize("hasRole('ADMIN') or @userSecurity.authorizeReviewEditing(#reviewId, #token)")
//    public ResponseEntity<?> updateReviewByReviewId(@PathVariable(value = "id") Long userId,
//                                                    @PathVariable("event_id") Long eventId,
//                                                    @Validated @RequestBody Review updatedReview,
//                                                    @PathVariable("review_id") Long reviewId) throws Exception {
//        Review review = reviewService.updateReviewById(reviewId, updatedReview)
//                .orElseThrow(() -> new Exception("Review is not updated."));
//        return ResponseEntity.ok().body(review);
//    }
//
//    /**
//     * Handle delete request to delete a review by ID.
//     * Allow review deletion only to review creators and admins.
//     */
//    @DeleteMapping("/{id}/events/{event_id}/reviews/{review_id}")
//    @PreAuthorize("hasRole('ADMIN') or @userSecurity.authorizeReviewEditing(#reviewId, #token)")
//    public ResponseEntity<?> deleteReviewById(@PathVariable(value = "id") Long userId,
//                                              @PathVariable("event_id") Long eventId,
//                                              @PathVariable("review_id") Long reviewId) throws Exception {
//
//        reviewService.deleteReviewById(reviewId, eventId);
//        return new ResponseEntity<>("Review is deleted successfully", HttpStatus.OK);
//    }
}
