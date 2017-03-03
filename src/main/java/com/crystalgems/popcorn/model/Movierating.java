package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Movierating {
    private int movieId;
    private String distribution;
    private int votes;
    private int rating;

    @Id
    @Column(name = "MovieId")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "Distribution")
    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    @Basic
    @Column(name = "Votes")
    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Basic
    @Column(name = "Rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movierating that = (Movierating) o;

        if (movieId != that.movieId) return false;
        if (votes != that.votes) return false;
        if (rating != that.rating) return false;
        return distribution != null ? distribution.equals(that.distribution) : that.distribution == null;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (distribution != null ? distribution.hashCode() : 0);
        result = 31 * result + votes;
        result = 31 * result + rating;
        return result;
    }
}
