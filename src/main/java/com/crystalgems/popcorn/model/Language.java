package com.crystalgems.popcorn.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "language")
public class Language {
    private int languageId;
    private String language;
    private Set<Movie> movies;

    @Id
    @Column(name = "LanguageId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "Language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @ManyToMany
    @JoinTable(
            name = "movielanguage",
            joinColumns = @JoinColumn(name = "LanguageId"),
            inverseJoinColumns = @JoinColumn(name = "MovieId")
    )
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

        Language language1 = (Language) o;

        if (languageId != language1.languageId) return false;
        return language != null ? language.equals(language1.language) : language1.language == null;
    }

    @Override
    public int hashCode() {
        int result = languageId;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
