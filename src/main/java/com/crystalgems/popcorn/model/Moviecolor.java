package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "moviecolor")
public class Moviecolor {
    private int movieId;
    private int colorId;
    //private String colorInfo;

    @Id
    @Column(name = "MovieId")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "ColorId")
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
/*
    @Basic
    @Column(name = "ColorInfo")
    public String getColorInfo() {
        return colorInfo;
    }

    public void setColorInfo(String colorInfo) {
        this.colorInfo = colorInfo;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviecolor that = (Moviecolor) o;

        if (movieId != that.movieId) return false;
        if (colorId != that.colorId) return false;
        //return colorInfo != null ? colorInfo.equals(that.colorInfo) : that.colorInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + colorId;
        //result = 31 * result + (colorInfo != null ? colorInfo.hashCode() : 0);
        return result;
    }
}
