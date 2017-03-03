package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "producer")
public class Producer {
    private int producerId;
    private String lastName;
    private String firstName;
    private int movieQuantity;

    @Id
    @Column(name = "ProducerId")
    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producer producer = (Producer) o;

        if (producerId != producer.producerId) return false;
        if (movieQuantity != producer.movieQuantity) return false;
        if (lastName != null ? !lastName.equals(producer.lastName) : producer.lastName != null) return false;
        return firstName != null ? firstName.equals(producer.firstName) : producer.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = producerId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + movieQuantity;
        return result;
    }
}
