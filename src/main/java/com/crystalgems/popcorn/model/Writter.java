package com.crystalgems.popcorn.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "writter")
public class Writter {
    private int writterId;
    private int movieQuantity;
    private String lastName;
    private String firstName;

    @Id
    @Column(name = "WritterId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getWritterId() {
        return writterId;
    }

    public void setWritterId(int writterId) {
        this.writterId = writterId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writter writter = (Writter) o;
        return Objects.equals(lastName, writter.lastName) &&
                Objects.equals(firstName, writter.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}
