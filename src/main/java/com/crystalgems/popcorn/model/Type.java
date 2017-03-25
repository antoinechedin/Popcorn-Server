package com.crystalgems.popcorn.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "type")
public class Type {
    private int typeId;
    private String type;
    private String typeDescription;
    private Set<Movie> movies;

    @Id
    @Column(name = "TypeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "TypeDescription")
    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    @OneToMany(mappedBy = "type")
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

        Type type1 = (Type) o;

        if (typeId != type1.typeId) return false;
        if (type != null ? !type.equals(type1.type) : type1.type != null) return false;
        return typeDescription != null ? typeDescription.equals(type1.typeDescription) : type1.typeDescription == null;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (typeDescription != null ? typeDescription.hashCode() : 0);
        return result;
    }
}
