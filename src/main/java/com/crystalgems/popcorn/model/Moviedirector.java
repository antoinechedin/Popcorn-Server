package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Moviedirector {
    private int movieDirectorLinkId;
    private int movieId;
    private int directorId;
    private String directorAlias;
    private String directorInfo;

    @Id
    @Column(name = "MovieDirectorLinkId")
    public int getMovieDirectorLinkId() {
        return movieDirectorLinkId;
    }

    public void setMovieDirectorLinkId(int movieDirectorLinkId) {
        this.movieDirectorLinkId = movieDirectorLinkId;
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
    @Column(name = "DirectorId")
    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Basic
    @Column(name = "DirectorAlias")
    public String getDirectorAlias() {
        return directorAlias;
    }

    public void setDirectorAlias(String directorAlias) {
        this.directorAlias = directorAlias;
    }

    @Basic
    @Column(name = "DirectorInfo")
    public String getDirectorInfo() {
        return directorInfo;
    }

    public void setDirectorInfo(String directorInfo) {
        this.directorInfo = directorInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviedirector that = (Moviedirector) o;

        if (movieDirectorLinkId != that.movieDirectorLinkId) return false;
        if (movieId != that.movieId) return false;
        if (directorId != that.directorId) return false;
        if (directorAlias != null ? !directorAlias.equals(that.directorAlias) : that.directorAlias != null)
            return false;
        return directorInfo != null ? directorInfo.equals(that.directorInfo) : that.directorInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieDirectorLinkId;
        result = 31 * result + movieId;
        result = 31 * result + directorId;
        result = 31 * result + (directorAlias != null ? directorAlias.hashCode() : 0);
        result = 31 * result + (directorInfo != null ? directorInfo.hashCode() : 0);
        return result;
    }
}
