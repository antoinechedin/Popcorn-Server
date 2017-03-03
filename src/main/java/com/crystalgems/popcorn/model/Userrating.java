package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Userrating {
    private int userRatingLinkId;
    private int userId;
    private int movieId;
    private int rating;
    private int timeStamp;

    @Id
    @Column(name = "UserRatingLinkId")
    public int getUserRatingLinkId() {
        return userRatingLinkId;
    }

    public void setUserRatingLinkId(int userRatingLinkId) {
        this.userRatingLinkId = userRatingLinkId;
    }

    @Basic
    @Column(name = "UserId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "Rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "TimeStamp")
    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userrating that = (Userrating) o;

        if (userRatingLinkId != that.userRatingLinkId) return false;
        if (userId != that.userId) return false;
        if (movieId != that.movieId) return false;
        if (rating != that.rating) return false;
        return timeStamp == that.timeStamp;
    }

    @Override
    public int hashCode() {
        int result = userRatingLinkId;
        result = 31 * result + userId;
        result = 31 * result + movieId;
        result = 31 * result + rating;
        result = 31 * result + timeStamp;
        return result;
    }
}
