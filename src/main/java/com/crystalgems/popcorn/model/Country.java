package com.crystalgems.popcorn.model;

import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "country")
public class Country {
    private int countryId;
    private String country;
    private String longName;
    private String domainCode;
    private String continent;
    private Set<Movie> movies;

    @Id
    @Column(name = "CountryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "LongName")
    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    @Basic
    @Column(name = "DomainCode")
    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    @Basic
    @Column(name = "Continent")
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @ManyToMany
    @JoinTable(
            name = "moviecountry",
            joinColumns = @JoinColumn(name = "CountryId", referencedColumnName = "CountryId"),
            inverseJoinColumns = @JoinColumn(name = "MovieId", referencedColumnName = "MovieId")
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
        Country country1 = (Country) o;
        return Objects.equals(country, country1.country) &&
                Objects.equals(longName, country1.longName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, longName);
    }
}
