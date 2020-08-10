package com.example.eventApplication.repository;

import com.example.eventApplication.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Event JPA Repository for data access.
 *
 * @author Margarita Zargaryan
 */

public interface EventRepository extends JpaRepository<Event, Long> {

    @Override
    Optional<Event> findById(Long aLong);

    @Override
    List<Event> findAll();

    @Override
    boolean existsById(Long aLong);


}
