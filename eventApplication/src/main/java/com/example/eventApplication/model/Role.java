package com.example.eventApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Entity class for Role model.
 *
 * @author Margarita Zargaryan
 */

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @NaturalId
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleName name;

    //constructors
    public Role() {
    }

    public Role(@JsonProperty("role_id") Long id, @JsonProperty("role_name") RoleName name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getters and setters for attributes of Reviews table.
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
