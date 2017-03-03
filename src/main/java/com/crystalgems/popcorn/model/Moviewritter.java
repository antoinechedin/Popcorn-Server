package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Moviewritter {
    private int movieWritterLinkId;
    private int movieId;
    private int writterId;
    private String writterInfo;

    @Id
    @Column(name = "MovieWritterLinkId")
    public int getMovieWritterLinkId() {
        return movieWritterLinkId;
    }

    public void setMovieWritterLinkId(int movieWritterLinkId) {
        this.movieWritterLinkId = movieWritterLinkId;
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
    @Column(name = "WritterId")
    public int getWritterId() {
        return writterId;
    }

    public void setWritterId(int writterId) {
        this.writterId = writterId;
    }

    @Basic
    @Column(name = "WritterInfo")
    public String getWritterInfo() {
        return writterInfo;
    }

    public void setWritterInfo(String writterInfo) {
        this.writterInfo = writterInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviewritter that = (Moviewritter) o;

        if (movieWritterLinkId != that.movieWritterLinkId) return false;
        if (movieId != that.movieId) return false;
        if (writterId != that.writterId) return false;
        return writterInfo != null ? writterInfo.equals(that.writterInfo) : that.writterInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieWritterLinkId;
        result = 31 * result + movieId;
        result = 31 * result + writterId;
        result = 31 * result + (writterInfo != null ? writterInfo.hashCode() : 0);
        return result;
    }
}
