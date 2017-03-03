package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "moviecountry")
public class Moviecountry {
    private int movieCountryLinkId;
    private int movieId;
    private int countryId;

    @Id
    @Column(name = "MovieCountryLinkId")
    public int getMovieCountryLinkId() {
        return movieCountryLinkId;
    }

    public void setMovieCountryLinkId(int movieCountryLinkId) {
        this.movieCountryLinkId = movieCountryLinkId;
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
    @Column(name = "CountryId")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviecountry that = (Moviecountry) o;

        if (movieCountryLinkId != that.movieCountryLinkId) return false;
        if (movieId != that.movieId) return false;
        return countryId == that.countryId;
    }

    @Override
    public int hashCode() {
        int result = movieCountryLinkId;
        result = 31 * result + movieId;
        result = 31 * result + countryId;
        return result;
    }
}
