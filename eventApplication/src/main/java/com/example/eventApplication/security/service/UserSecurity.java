package com.example.eventApplication.security.service;

import com.example.eventApplication.model.Review;
import com.example.eventApplication.model.User;
import com.example.eventApplication.security.jwt.JwtProvider;
import com.example.eventApplication.service.serviceInterface.ReviewService;
import com.example.eventApplication.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Java bean for providing user authorization over certain operations.
 *
 * @author Margarita Zargaryan
 */

@Component("userSecurity")
public class UserSecurity {

    @Autowired
    public JwtProvider jwtProvider;

    @Autowired
    public UserService userService;

    @Autowired
    public ReviewService reviewService;

    /**
     * Provide access to user editing and deletion and event posting, editing and deletion.
     */
    public boolean authorizeUserAccess(Long userId, String token) throws Exception {
        String username = getUsernameFromToken(token);
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new Exception(" User by ID" + userId + "not found!"));
        return (user.getName()).equals(username);
    }


    public String getUsernameFromToken(String token) {
        return jwtProvider.getUserNameFromJwtToken(token);
    }

    /**
     * Provide access to review editing and deletion.
     */
    public boolean authorizeReviewEditing(Long reviewId, String token) throws Exception {
        String username = getUsernameFromToken(token);
        Review review = reviewService.getReviewById(reviewId)
                .orElseThrow(() -> new Exception(" Review by ID" + reviewId + "not found!"));
        return username.equals(review.getUser().getName());
    }

}
