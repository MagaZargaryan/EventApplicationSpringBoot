package com.example.eventApplication.model;

import javax.persistence.*;
import java.util.*;

/**
 * Entity class for User model.
 * <p>
 * Used for user registration and authentication of users.
 *
 * @author Margarita Zargaryan
 */
@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    //constructors
    public User(Long id, String username,
                String firstName, String lastName,
                String email, String password) {

        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    public User(String username, String firstName,
                String lastName, String email,
                String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    //default constructor
    public User() {

    }

    /**
     * Many-to-many mapping between Users and Events entities.
     * Getting collection of events from join table.
     */

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_event",
            joinColumns = @JoinColumn(name = "user_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "event_id_fk"))
    private Set<Event> events = new HashSet<>();

    /**
     * Many-to-many mapping between Users and Roles entities.
     * Getting collection of roles from join table.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /**
     * One-to-many mapping to get reviews that users wrote.
     */
    @OneToMany(mappedBy = "user")
    private Set<Review> reviews = new HashSet<>();

    /**
     * Getters and Setters for all attributes.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    /**
     * Removing an event element from collection of events.
     */

    public void removeEvent(Event article) {
        this.events.remove(article);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
