package com.crystalgems.popcorn.model;

import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "gender")
public class Gender {
    private int genderId;
    private String gender;
    private Set<User> users;

    @Id
    @Column(name = "GenderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    @Basic
    @Column(name = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @OneToMany(mappedBy = "gender")
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

        Gender gender1 = (Gender) o;

        if (genderId != gender1.genderId) return false;
        return gender != null ? gender.equals(gender1.gender) : gender1.gender == null;
    }

    @Override
    public int hashCode() {
        int result = genderId;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
