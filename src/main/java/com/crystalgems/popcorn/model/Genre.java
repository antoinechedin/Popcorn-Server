package com.crystalgems.popcorn.model;

import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "genre")
public class Genre {
    private int genreId;
    private String genre;
    private Set<Movie> movies;

    @Id
    @Column(name = "GenreId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    @JoinTable(
            name = "moviegenre",
            joinColumns = @JoinColumn(name = "GenreId", referencedColumnName = "GenreId"),
            inverseJoinColumns = @JoinColumn(name = "MovieId", referencedColumnName = "Movieid")
    )
    @JsonIgnore
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre1 = (Genre) o;

        return genre != null ? genre.equals(genre1.genre) : genre1.genre == null;
    }

    @Override
    public int hashCode() {
        int result = genreId;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
