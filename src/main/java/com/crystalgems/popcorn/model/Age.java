package com.crystalgems.popcorn.model;

import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "age")
public class Age {
    private int ageId;
    private int minAge;
    private int maxAge;
    private Set<User> users;

    @Id
    @Column(name = "AgeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "age")
    @JsonIgnore
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Age age = (Age) o;
        return minAge == age.minAge &&
                maxAge == age.maxAge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minAge, maxAge);
    }
}
