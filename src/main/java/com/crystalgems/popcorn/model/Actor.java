package com.crystalgems.popcorn.model;

import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "actor")
public class Actor {
    private int actorId;
    private String lastName;
    private String firstName;
    private int movieQuantity;
    private Set<Movie> movies;

    @Id
    @Column(name = "ActorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "MovieQuantity")
    public int getMovieQuantity() {
        return movieQuantity;
    }

    public void setMovieQuantity(int movieQuantity) {
        this.movieQuantity = movieQuantity;
    }

    @ManyToMany
    @JoinTable(
            name = "movieactor",
            joinColumns = @JoinColumn(name = "ActorId", referencedColumnName = "ActorId"),
            inverseJoinColumns = @JoinColumn(name = "MovieId", referencedColumnName = "MovieId")
    )
    @JsonIgnore
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(lastName, actor.lastName) &&
                Objects.equals(firstName, actor.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}
