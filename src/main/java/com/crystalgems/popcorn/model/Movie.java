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
    private Set<Actor> actors;
    private Set<Genre> genres;
    private Set<Country> countries;
    private Set<Distributor> distributors;

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
            joinColumns = @JoinColumn(name = "MovieId", referencedColumnName = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "DirectorId", referencedColumnName = "DirectorId")

    )
    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    @ManyToMany
    @JoinTable(
            name = "movieactor",
            joinColumns = @JoinColumn(name = "MovieId", referencedColumnName = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "ActorId", referencedColumnName = "ActorId")
    )
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @ManyToMany
    @JoinTable(
            name = "moviegenre",
            joinColumns = @JoinColumn(name = "MovieId", referencedColumnName = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "GenreId", referencedColumnName = "GenreId")
    )
    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @ManyToMany
    @JoinTable(
            name = "moviecountry",
            joinColumns = @JoinColumn(name = "MovieId", referencedColumnName = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "CountryId", referencedColumnName = "CountryId")
    )
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    @ManyToMany
    @JoinTable(
            name = "moviedistributor",
            joinColumns = @JoinColumn(name = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "DistributionCompanyId")
    )
    public Set<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(Set<Distributor> distributors) {
        this.distributors = distributors;
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
