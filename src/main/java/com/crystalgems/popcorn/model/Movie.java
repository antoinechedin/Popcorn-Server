package com.crystalgems.popcorn.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "movies")
public class Movie {
    private int movieId;
    private String titleMovieLens;
    private String titleImdb;
    private Date date;
    private Set<Director> directors;

    @Id
    @Column(name = "MovieId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "TitleMovieLens")
    public String getTitleMovieLens() {
        return titleMovieLens;
    }

    public void setTitleMovieLens(String titleMovieLens) {
        this.titleMovieLens = titleMovieLens;
    }

    @Basic
    @Column(name = "TitleIMDB")
    public String getTitleImdb() {
        return titleImdb;
    }

    public void setTitleImdb(String titleImdb) {
        this.titleImdb = titleImdb;
    }

    @Basic
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToMany
    @JoinTable(
            name = "moviedirector",
            joinColumns = @JoinColumn(name = "DirectorId"),
            inverseJoinColumns = @JoinColumn(name = "MovieId")
    )
    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (titleMovieLens != null ? !titleMovieLens.equals(movie.titleMovieLens) : movie.titleMovieLens != null)
            return false;
        if (titleImdb != null ? !titleImdb.equals(movie.titleImdb) : movie.titleImdb != null) return false;
        return date != null ? date.equals(movie.date) : movie.date == null;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (titleMovieLens != null ? titleMovieLens.hashCode() : 0);
        result = 31 * result + (titleImdb != null ? titleImdb.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
