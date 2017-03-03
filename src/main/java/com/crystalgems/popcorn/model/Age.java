package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "age")
public class Age {
    private int ageId;
    private int minAge;
    private int maxAge;

    @Id
    @Column(name = "AgeId")
    public int getAgeId() {
        return ageId;
    }

    public void setAgeId(int ageId) {
        this.ageId = ageId;
    }

    @Basic
    @Column(name = "MinAge")
    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Basic
    @Column(name = "MaxAge")
    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Age age = (Age) o;

        if (ageId != age.ageId) return false;
        if (minAge != age.minAge) return false;
        return maxAge == age.maxAge;
    }

    @Override
    public int hashCode() {
        int result = ageId;
        result = 31 * result + minAge;
        result = 31 * result + maxAge;
        return result;
    }
}
