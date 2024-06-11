package de.htwberlin.webtechsose24;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    private User() {}

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}