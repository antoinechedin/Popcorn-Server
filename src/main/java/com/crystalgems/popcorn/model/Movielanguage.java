package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "movielanguage")
public class Movielanguage {
    private int movieLanguageLinkId;
    private int movieId;
    private int languageId;
    private String languageInfo;

    @Id
    @Column(name = "MovieLanguageLinkId")
    public int getMovieLanguageLinkId() {
        return movieLanguageLinkId;
    }

    public void setMovieLanguageLinkId(int movieLanguageLinkId) {
        this.movieLanguageLinkId = movieLanguageLinkId;
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
    @Column(name = "LanguageId")
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "LanguageInfo")
    public String getLanguageInfo() {
        return languageInfo;
    }

    public void setLanguageInfo(String languageInfo) {
        this.languageInfo = languageInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movielanguage that = (Movielanguage) o;

        if (movieLanguageLinkId != that.movieLanguageLinkId) return false;
        if (movieId != that.movieId) return false;
        if (languageId != that.languageId) return false;
        return languageInfo != null ? languageInfo.equals(that.languageInfo) : that.languageInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieLanguageLinkId;
        result = 31 * result + movieId;
        result = 31 * result + languageId;
        result = 31 * result + (languageInfo != null ? languageInfo.hashCode() : 0);
        return result;
    }
}
