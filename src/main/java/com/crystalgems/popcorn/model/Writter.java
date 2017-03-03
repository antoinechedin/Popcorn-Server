package com.crystalgems.popcorn.model;

import javax.persistence.*;

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

        if (writterId != writter.writterId) return false;
        if (movieQuantity != writter.movieQuantity) return false;
        if (lastName != null ? !lastName.equals(writter.lastName) : writter.lastName != null) return false;
        return firstName != null ? firstName.equals(writter.firstName) : writter.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = writterId;
        result = 31 * result + movieQuantity;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
