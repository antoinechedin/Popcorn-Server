package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Movierunningtime {
    private int movieRunningLinkId;
    private int movieId;
    private int countryId;
    private int duration;
    private String runningInfo;

    @Id
    @Column(name = "MovieRunningLinkId")
    public int getMovieRunningLinkId() {
        return movieRunningLinkId;
    }

    public void setMovieRunningLinkId(int movieRunningLinkId) {
        this.movieRunningLinkId = movieRunningLinkId;
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

    @Basic
    @Column(name = "Duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "RunningInfo")
    public String getRunningInfo() {
        return runningInfo;
    }

    public void setRunningInfo(String runningInfo) {
        this.runningInfo = runningInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movierunningtime that = (Movierunningtime) o;

        if (movieRunningLinkId != that.movieRunningLinkId) return false;
        if (movieId != that.movieId) return false;
        if (countryId != that.countryId) return false;
        if (duration != that.duration) return false;
        return runningInfo != null ? runningInfo.equals(that.runningInfo) : that.runningInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieRunningLinkId;
        result = 31 * result + movieId;
        result = 31 * result + countryId;
        result = 31 * result + duration;
        result = 31 * result + (runningInfo != null ? runningInfo.hashCode() : 0);
        return result;
    }
}
