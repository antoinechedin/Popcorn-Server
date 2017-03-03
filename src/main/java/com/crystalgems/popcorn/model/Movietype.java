package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "movietype")
public class Movietype {
    private int movieId;
    private int typeId;

    @Id
    @Column(name = "MovieId")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "TypeId")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movietype movietype = (Movietype) o;

        if (movieId != movietype.movieId) return false;
        return typeId == movietype.typeId;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + typeId;
        return result;
    }
}
