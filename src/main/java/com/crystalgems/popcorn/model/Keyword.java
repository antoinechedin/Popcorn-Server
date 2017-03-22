package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "keyword")
public class Keyword {
    private int keywordId;
    private String keyword;
    private int movieQuantity;

    @Id
    @Column(name = "KeywordId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    @Basic
    @Column(name = "Keyword")
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "MovieQuantity")
    public int getMovieQuantity() {
        return movieQuantity;
    }

    public void setMovieQuantity(int movieQuantity) {
        this.movieQuantity = movieQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Keyword keyword1 = (Keyword) o;

        if (keywordId != keyword1.keywordId) return false;
        if (movieQuantity != keyword1.movieQuantity) return false;
        return keyword != null ? keyword.equals(keyword1.keyword) : keyword1.keyword == null;
    }

    @Override
    public int hashCode() {
        int result = keywordId;
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + movieQuantity;
        return result;
    }
}
