package com.crystalgems.popcorn.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "director")
public class Director {
    private int directorId;
    private int movieQuantity;
    private String lastName;
    private String firstName;
    private Set<Movie> movies;

    @Id
    @Column(name = "DirectorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Basic
    @Column(name = "MovieQuantity")
    public int getMovieQuantity() {
        return movieQuantity;
    }

    public void setMovieQuantity(int movieQuantity) {
        this.movieQuantity = movieQuantity;
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

    @ManyToMany
    @JoinTable(
            name = "moviedirector",
            joinColumns = @JoinColumn(name = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "DirectorId")
    )
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

        Director director = (Director) o;

        if (movieQuantity != director.movieQuantity) return false;
        if (lastName != null ? !lastName.equals(director.lastName) : director.lastName != null) return false;
        return firstName != null ? firstName.equals(director.firstName) : director.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = directorId;
        result = 31 * result + movieQuantity;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
