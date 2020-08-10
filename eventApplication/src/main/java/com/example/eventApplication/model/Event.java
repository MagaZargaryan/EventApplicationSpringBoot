package com.example.eventApplication.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class for Event model.
 *
 * @author Margarita Zargaryan
 */

@Entity
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;


    //constructors
    public Event(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Event(String title, String text) {
        this.title = title;
        this.text = text;
    }

    //default constructor
    public Event() {
    }

    /**
     * One-to-many mapping for reviews of events.
     */

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();



    /**
     * One-to-many mapping for categories of events.
     */

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Category> categories;


    /**
     * Setters and getters for attributes of Events table.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

}
