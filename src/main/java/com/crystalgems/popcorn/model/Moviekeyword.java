package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "moviekeyword")
public class Moviekeyword {
    private int movieKeywordLinkId;
    private int movieId;
    private int keywordId;

    @Id
    @Column(name = "MovieKeywordLinkId")
    public int getMovieKeywordLinkId() {
        return movieKeywordLinkId;
    }

    public void setMovieKeywordLinkId(int movieKeywordLinkId) {
        this.movieKeywordLinkId = movieKeywordLinkId;
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
    @Column(name = "KeywordId")
    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviekeyword that = (Moviekeyword) o;

        if (movieKeywordLinkId != that.movieKeywordLinkId) return false;
        if (movieId != that.movieId) return false;
        return keywordId == that.keywordId;
    }

    @Override
    public int hashCode() {
        int result = movieKeywordLinkId;
        result = 31 * result + movieId;
        result = 31 * result + keywordId;
        return result;
    }
}
