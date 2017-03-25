package com.crystalgems.popcorn.model;

import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "occupation")
public class Occupation {
    private int occupationId;
    private String occupation;
    private Set<User> users;

    @Id
    @Column(name = "OccupationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "occupation")
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
