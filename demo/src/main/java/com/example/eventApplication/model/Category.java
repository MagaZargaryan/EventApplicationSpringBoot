package com.example.eventApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Entity class for Category model.
 *
 * @author Margarita Zargaryan
 */

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    //constructors
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    //default constructor
    public Category() {
    }

    /**
     * Many-to-one mapping for the event that category belongs to.
     */

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    @JsonIgnore
    private Event event;

    /**
     * Getters and setters for the attributes of Categories table.
     */
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event article) {
        this.event = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
