package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "moviewritter")
public class Moviewritter {
    private int id;
    private int movieId;
    private int writterId;
    //private String writterInfo;

    @Id
    @Column(name = "MovieWritterLinkId")
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
    @Column(name = "WritterId")
    public int getWritterId() {
        return writterId;
    }

    public void setWritterId(int writterId) {
        this.writterId = writterId;
    }
/*
    @Basic
    @Column(name = "WritterInfo")
    public String getWritterInfo() {
        return writterInfo;
    }

    public void setWritterInfo(String writterInfo) {
        this.writterInfo = writterInfo;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviewritter that = (Moviewritter) o;

        if (id != that.id) return false;
        if (movieId != that.movieId) return false;
        return writterId != that.writterId;
        //return writterInfo != null ? writterInfo.equals(that.writterInfo) : that.writterInfo == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + movieId;
        result = 31 * result + writterId;
        //result = 31 * result + (writterInfo != null ? writterInfo.hashCode() : 0);
        return result;
    }
}
