package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "occupation")
public class Occupation {
    private int occupationId;
    private String occupation;

    @Id
    @Column(name = "OccupationId")
    public int getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(int occupationId) {
        this.occupationId = occupationId;
    }

    @Basic
    @Column(name = "Occupation")
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Occupation that = (Occupation) o;

        if (occupationId != that.occupationId) return false;
        return occupation != null ? occupation.equals(that.occupation) : that.occupation == null;
    }

    @Override
    public int hashCode() {
        int result = occupationId;
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        return result;
    }
}
