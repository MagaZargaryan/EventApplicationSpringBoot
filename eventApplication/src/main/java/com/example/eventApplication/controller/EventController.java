package com.example.eventApplication.controller;

import com.example.eventApplication.repository.EventRepository;
import com.example.eventApplication.repository.CategoryRepository;
import com.example.eventApplication.repository.UserRepository;
import com.example.eventApplication.message.request.EventForm;
import com.example.eventApplication.model.Event;
import com.example.eventApplication.service.serviceImplementation.EventServiceImpl;
import com.example.eventApplication.service.serviceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Event Rest controller class file for request handling and execution of CRUD operations.
 *
 * @author Margarita Zargaryan
 */

@RequestMapping("api/users")
@RestController
public class EventController {

    private final EventServiceImpl eventService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository articleRepository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthenticationController authenticationAPI;

    @Autowired
    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    /**
     * Handle get request to get events of a user.
     */
    @GetMapping("/{id}/events")
    public ResponseEntity<Set<Event>> getEventByUserId(@PathVariable(value = "id") Long userId) throws Exception {
        Set<Event> events = eventService.getEventsByUserId(userId);
        return ResponseEntity.ok().body(events);
    }

    /**
     * Handle post request to add an event.
     * Allow only admin or account owner to add a new event.
     */
    @PostMapping("/{id}/events/new")
    @PreAuthorize("hasRole('ADMIN') or @userSecurity.authorizeUserAccess(#userId, #token)")
    public ResponseEntity<?> addEventByUserId(@PathVariable(value = "id") Long userId,
                                              @Validated @RequestBody EventForm response,
                                              @RequestHeader("Authorization") String token) throws Exception {

        eventService.addEventByUserId(userId, response)
                .orElseThrow(() -> new Exception("Event is not added."));
        return new ResponseEntity<>("Event is added successfully", HttpStatus.CREATED);

    }

    /**
     * Handle get request to get event of a user.
     */
    @GetMapping("/{id}/events/{event_id}")
    public ResponseEntity<?> getEventByEventId(@PathVariable(value = "id") Long userId,
                                               @PathVariable("event_id") Long eventId) throws Exception {
        Event event = eventService.getEventById(eventId)
                .orElseThrow(() -> new Exception(("Event" + eventId + "not found")));
        return ResponseEntity.ok().body(event);
    }

    /**
     * Handle put request to update an event of a user.
     * Allow only admin and account owner to update user's event info.
     */
    @PutMapping("/{id}/events/{event_id}")
    @PreAuthorize("hasRole('ADMIN') or @userSecurity.authorizeUserAccess(#userId, #token)")
    public ResponseEntity<?> updateEventByEventId(@PathVariable(value = "id") Long userId,
                                                  @PathVariable("event_id") Long eventId,
                                                  @Validated @RequestBody Event updatedEvent,
                                                  @RequestHeader("Authorization") String token) throws Exception {
        Event event = eventService.updateEventById(eventId, updatedEvent)
                .orElseThrow(() -> new Exception("Event" + eventId + "not found."));
        return ResponseEntity.ok().body(event);
    }

    /**
     * Handle delete request to delete an event of a user.
     * Allow only admin and account owner to delete event.
     */
    @DeleteMapping("/{id}/events/{event_id}")
    @PreAuthorize("hasRole('ADMIN') or @userSecurity.authorizeUserAccess(#userId, #token)")
    public ResponseEntity<?> deleteEventByEventId(@PathVariable(value = "id") Long userId,
                                                  @PathVariable("event_id") Long articleId,
                                                  @RequestHeader("Authorization") String token) throws Exception {

        eventService.deleteEventById(userId, articleId);
        return new ResponseEntity<>("Event is deleted successfully", HttpStatus.OK);
    }

    /**
     * Handle get request to get all events.
     */
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() throws Exception {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok().body(events);
    }

}
