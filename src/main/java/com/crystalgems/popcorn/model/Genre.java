package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "genre")
public class Genre {
    private int genreId;
    private String genre;

    @Id
    @Column(name = "GenreId")
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name = "Genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre1 = (Genre) o;

        if (genreId != genre1.genreId) return false;
        return genre != null ? genre.equals(genre1.genre) : genre1.genre == null;
    }

    @Override
    public int hashCode() {
        int result = genreId;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
