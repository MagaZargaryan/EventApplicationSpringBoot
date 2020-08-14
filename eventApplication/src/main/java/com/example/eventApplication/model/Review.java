package com.example.eventApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Entity class for Review model.
 *
 * @author Margarita Zargaryan
 */

@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "text")
    private String text;

    //default constructor
    public Review() {
    }

    //constructors
    public Review(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Review(@JsonProperty(value = "text") String text) {
        this.text = text;
    }

    /**
     * Many-to-one mapping for events that reviews belong to.
     */

    @ManyToOne(fetch = FetchType.LAZY,   optional = false)
    @JoinColumn(name = "event_id_fk", nullable = false)
    @JsonIgnore
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY,  optional = false)
    @JoinColumn(name = "user_id_fk", nullable = false)
    @JsonIgnore
    private User user;

    /**
     * Getters and setters for attributes of Reviews table.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
