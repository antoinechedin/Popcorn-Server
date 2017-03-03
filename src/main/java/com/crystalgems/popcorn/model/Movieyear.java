package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Movieyear {
    private int movieYearLinkId;
    private int movieId;
    private int year;
    private String yearInfo;

    @Id
    @Column(name = "MovieYearLinkId")
    public int getMovieYearLinkId() {
        return movieYearLinkId;
    }

    public void setMovieYearLinkId(int movieYearLinkId) {
        this.movieYearLinkId = movieYearLinkId;
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
    @Column(name = "Year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "YearInfo")
    public String getYearInfo() {
        return yearInfo;
    }

    public void setYearInfo(String yearInfo) {
        this.yearInfo = yearInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movieyear movieyear = (Movieyear) o;

        if (movieYearLinkId != movieyear.movieYearLinkId) return false;
        if (movieId != movieyear.movieId) return false;
        if (year != movieyear.year) return false;
        return yearInfo != null ? yearInfo.equals(movieyear.yearInfo) : movieyear.yearInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieYearLinkId;
        result = 31 * result + movieId;
        result = 31 * result + year;
        result = 31 * result + (yearInfo != null ? yearInfo.hashCode() : 0);
        return result;
    }
}
