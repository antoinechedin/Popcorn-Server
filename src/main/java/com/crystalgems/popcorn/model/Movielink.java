package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "movielink")
public class Movielink {
    private int id;
    private int movieId;
    private int linkedMovieId;
    private int linkTypeId;

    @Id
    @Column(name = "MovieLinkId")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MovieId")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "LinkedMovieId")
    public int getLinkedMovieId() {
        return linkedMovieId;
    }

    public void setLinkedMovieId(int linkedMovieId) {
        this.linkedMovieId = linkedMovieId;
    }

    @Basic
    @Column(name = "LinkTypeId")
    public int getLinkTypeId() {
        return linkTypeId;
    }

    public void setLinkTypeId(int linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movielink movielink = (Movielink) o;

        if (id != movielink.id) return false;
        if (movieId != movielink.movieId) return false;
        if (linkedMovieId != movielink.linkedMovieId) return false;
        return linkTypeId == movielink.linkTypeId;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + movieId;
        result = 31 * result + linkedMovieId;
        result = 31 * result + linkTypeId;
        return result;
    }
}
