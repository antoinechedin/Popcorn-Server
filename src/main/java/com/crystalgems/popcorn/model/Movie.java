package com.crystalgems.popcorn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
    private int year;
    private Set<Director> directors;
    private Set<Actor> actors;
    private Set<Genre> genres;
    private Set<Country> countries;
    private Set<Distributor> distributors;
    private Set<Keyword> keywords;
    private Set<Language> languages;
    private Set<Rating> ratings;

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
    @Column(name = "Date", length = 4)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @ManyToMany
    @JoinTable(
            name = "moviedirector",
            joinColumns = @JoinColumn(name = "MovieId", referencedColumnName = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "DirectorId", referencedColumnName = "DirectorId")

    )
    @JsonIgnore
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
    @JsonIgnore
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
    @JsonIgnore
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
    @JsonIgnore
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
    @JsonIgnore
    public Set<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(Set<Distributor> distributors) {
        this.distributors = distributors;
    }

    @ManyToMany
    @JoinTable(
            name = "moviekeyword",
            joinColumns = @JoinColumn(name = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "KeywordId")
    )
    @JsonIgnore
    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    @ManyToMany
    @JoinTable(
            name = "movielanguage",
            joinColumns = @JoinColumn(name = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "LanguageId")
    )
    @JsonIgnore
    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (titleMovieLens != null ? !titleMovieLens.equals(movie.titleMovieLens) : movie.titleMovieLens != null)
            return false;
        if (titleImdb != null ? !titleImdb.equals(movie.titleImdb) : movie.titleImdb != null) return false;
        return year == movie.year;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (titleMovieLens != null ? titleMovieLens.hashCode() : 0);
        result = 31 * result + (titleImdb != null ? titleImdb.hashCode() : 0);
        return result;
    }
}
