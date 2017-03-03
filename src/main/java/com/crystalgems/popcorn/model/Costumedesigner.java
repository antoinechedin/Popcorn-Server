package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "costumedesigner")
public class Costumedesigner {
    private int costumeDesignerId;
    private String lastName;
    private String firstName;

    @Id
    @Column(name = "CostumeDesignerId")
    public int getCostumeDesignerId() {
        return costumeDesignerId;
    }

    public void setCostumeDesignerId(int costumeDesignerId) {
        this.costumeDesignerId = costumeDesignerId;
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

        Costumedesigner that = (Costumedesigner) o;

        if (costumeDesignerId != that.costumeDesignerId) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = costumeDesignerId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
