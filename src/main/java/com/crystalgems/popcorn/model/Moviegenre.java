package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "moviegenre")
public class Moviegenre {
    private int movieGenreLinkId;
    private int movieId;
    private int genreId;

    @Id
    @Column(name = "MovieGenreLinkId")
    public int getMovieGenreLinkId() {
        return movieGenreLinkId;
    }

    public void setMovieGenreLinkId(int movieGenreLinkId) {
        this.movieGenreLinkId = movieGenreLinkId;
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
    @Column(name = "GenreId")
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviegenre that = (Moviegenre) o;

        if (movieGenreLinkId != that.movieGenreLinkId) return false;
        if (movieId != that.movieId) return false;
        return genreId == that.genreId;
    }

    @Override
    public int hashCode() {
        int result = movieGenreLinkId;
        result = 31 * result + movieId;
        result = 31 * result + genreId;
        return result;
    }
}
