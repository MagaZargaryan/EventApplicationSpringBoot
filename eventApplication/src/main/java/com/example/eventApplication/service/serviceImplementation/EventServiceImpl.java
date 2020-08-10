package com.example.eventApplication.service.serviceImplementation;

import com.example.eventApplication.repository.EventRepository;
import com.example.eventApplication.message.request.EventForm;
import com.example.eventApplication.model.Category;
import com.example.eventApplication.model.Event;
import com.example.eventApplication.model.User;
import com.example.eventApplication.service.serviceInterface.EventService;
import com.example.eventApplication.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Event Service Implementation for the integration of business logic.
 *
 * @author Margarita Zargaryan
 */

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Autowired
    public UserService userService;

    /**
     * Get all existing ec=vents from DB.
     */
    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Add event by ID.
     */
    @Override
    public Optional<Event> addEventByUserId(Long userId, EventForm eventForm) throws Exception {

        User user = userService.getUserById(userId)
                .orElseThrow(() -> new Exception(("User" + userId + "not found")));
        Event event = new Event(eventForm.getTitle(), eventForm.getText());
        Set<Category> categories = eventForm.getCategories();
        categories.forEach(category -> category.setEvent(event));
        event.setCategories(categories);
        user.getEvents().add(event);
        eventRepository.save(event);
        return Optional.of(event);

    }

    /**
     * Delete event by ID.
     */
    @Override
    public void deleteEventById(Long userId, Long eventId) throws Exception {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new Exception(("User" + userId + "not found")));
        Event article = eventRepository.findById(eventId)
                .orElseThrow(() -> new Exception(("Event" + eventId + "not found")));
        user.removeEvent(article);
        eventRepository.delete(article);
    }
    /**
     * Get event by ID.
     */
    @Override
    public Optional<Event> getEventById(Long id) throws Exception {

        Event article = eventRepository.findById(id)
                .orElseThrow(() -> new Exception(("Event" + id + "not found")));
        return eventRepository.findById(id);
    }

    /**
     * Get events of given user.
     */
    @Override
    public Set<Event> getEventsByUserId(Long id) throws Exception {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new Exception(("User" + id + "not found")));

        return user.getEvents();
    }

    /**
     * Update an event.
     */
    @Override
    public Optional<Event> updateEventById(Long eventId, Event updatedEvent) throws Exception {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new Exception(("Event" + eventId + "not found")));
        event.setText(updatedEvent.getText());
        event.setTitle(updatedEvent.getTitle());

        eventRepository.save(event);
        return Optional.of(event);
    }


}
