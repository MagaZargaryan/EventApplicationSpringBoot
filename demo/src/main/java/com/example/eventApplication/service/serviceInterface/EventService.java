package com.example.eventApplication.service.serviceInterface;

import com.example.eventApplication.message.request.EventForm;
import com.example.eventApplication.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Interface for Event Service.
 *
 * @author Margarita Zargaryan
 */

@Service
public interface EventService {

    public List<Event> getAllEvents();

    public Optional<Event> addEventByUserId(Long userId, EventForm event) throws Exception;

    public void deleteEventById(Long userId, Long eventId) throws Exception;

    public Optional<Event> getEventById(Long id) throws Exception;

    public Set<Event> getEventsByUserId(Long id) throws Exception;

    public Optional<Event> updateEventById(Long eventId, Event updatedEvent) throws Exception;

}
