package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "userrating")
public class Rating {
    private int userRatingLinkId;
    private User user;
    private Movie movie;
    private int rating;
    private int timeStamp;

    @Id
    @Column(name = "UserRatingLinkId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserRatingLinkId() {
        return userRatingLinkId;
    }

    public void setUserRatingLinkId(int userRatingLinkId) {
        this.userRatingLinkId = userRatingLinkId;
    }

    @ManyToOne
    @JoinColumn(name = "UserId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "MovieId")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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

        Rating that = (Rating) o;

        if (userRatingLinkId != that.userRatingLinkId) return false;
        if (user != that.user) return false;
        if (movie != that.movie) return false;
        if (rating != that.rating) return false;
        return timeStamp == that.timeStamp;
    }

    @Override
    public int hashCode() {
        int result = userRatingLinkId;
        result = result + (user != null ? user.hashCode() : 0);
        result = result + (movie != null ? movie.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + timeStamp;
        return result;
    }
}
