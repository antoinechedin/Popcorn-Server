package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Moviecostumedesigner {
    private int movieCostumeDesignerLinkId;
    private int movieId;
    private int costumeDesignerId;
    private String costumeInfo;

    @Id
    @Column(name = "MovieCostumeDesignerLinkId")
    public int getMovieCostumeDesignerLinkId() {
        return movieCostumeDesignerLinkId;
    }

    public void setMovieCostumeDesignerLinkId(int movieCostumeDesignerLinkId) {
        this.movieCostumeDesignerLinkId = movieCostumeDesignerLinkId;
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
    @Column(name = "CostumeDesignerId")
    public int getCostumeDesignerId() {
        return costumeDesignerId;
    }

    public void setCostumeDesignerId(int costumeDesignerId) {
        this.costumeDesignerId = costumeDesignerId;
    }

    @Basic
    @Column(name = "CostumeInfo")
    public String getCostumeInfo() {
        return costumeInfo;
    }

    public void setCostumeInfo(String costumeInfo) {
        this.costumeInfo = costumeInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviecostumedesigner that = (Moviecostumedesigner) o;

        if (movieCostumeDesignerLinkId != that.movieCostumeDesignerLinkId) return false;
        if (movieId != that.movieId) return false;
        if (costumeDesignerId != that.costumeDesignerId) return false;
        return costumeInfo != null ? costumeInfo.equals(that.costumeInfo) : that.costumeInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieCostumeDesignerLinkId;
        result = 31 * result + movieId;
        result = 31 * result + costumeDesignerId;
        result = 31 * result + (costumeInfo != null ? costumeInfo.hashCode() : 0);
        return result;
    }
}
