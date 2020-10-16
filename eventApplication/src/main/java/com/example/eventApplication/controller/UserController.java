package com.example.eventApplication.controller;

import com.example.eventApplication.security.jwt.JwtProvider;
import com.example.eventApplication.service.serviceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Rest controller class file for request handling and execution of CRUD operations.
 *
 * @author Margarita Zargaryan
 */

@RequestMapping("api")
@RestController
public class UserController {
    private final UserServiceImpl userService;


    @Autowired
    public JwtProvider jwtProvider;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


      /**
     * Handle get request to get all the users.
     */
//    @GetMapping
//    public List<User> getAllUsers() {
//
//        return userService.getAllUsers();
//    }

    /**
     * Handle post request to create a user.
     */
//
//    @PostMapping
//    public User createUser(@Validated @RequestBody User user) throws Exception {
//
//        return userService.postUser(user)
//                .orElseThrow(() -> new Exception("User is not created."));
//    }
//
//
//    /**
//     * Handle delete request to delete a user.
//     * Give authority to admin and account owner to delete the account.
//     */
//    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN') or @userSecurity.authorizeUserAccess(#userId, #token)")
//    public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") Long userId,
//                                            @RequestHeader("Authorization") String token) throws Exception {
//
//        userService.deleteUser(userId);
//        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
//    }
//
//    /**
//     * Handle get request to get a user by given id.
//     */
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long personId) throws Exception {
//        User user = userService.getUserById(personId)
//                .orElseThrow(() -> new Exception(("Person" + personId + "not found")));
//        return ResponseEntity.ok().body(user);
//    }
//
//    /**
//     * Handle put request to update a user.
//     * Give authority to admin and account owner to update the user details.
//     */
//    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN') or @userSecurity.authorizeUserAccess(#userId, #token)")
//    public ResponseEntity<?> updateUserById(@PathVariable(value = "id") Long userId,
//                                            @Validated @RequestBody User updatedUser,
//                                            @RequestHeader("Authorization") String token) throws Exception {
//        User user = userService.updateUserById(userId, updatedUser)
//                .orElseThrow(() -> new Exception("User is not updated."));
//        return ResponseEntity.ok().body(user);
//
//    }

}
