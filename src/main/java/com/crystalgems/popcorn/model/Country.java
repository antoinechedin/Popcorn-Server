package com.crystalgems.popcorn.model;

import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
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
    private String iso2Code;
    private String iso3Code;
    private String uNumericalCode;
    private String continent;
    private String secondaryContinent;
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
    @Column(name = "ISO2Code")
    public String getIso2Code() {
        return iso2Code;
    }

    public void setIso2Code(String iso2Code) {
        this.iso2Code = iso2Code;
    }

    @Basic
    @Column(name = "ISO3Code")
    public String getIso3Code() {
        return iso3Code;
    }

    public void setIso3Code(String iso3Code) {
        this.iso3Code = iso3Code;
    }

    @Basic
    @Column(name = "UNumericalCode")
    public String getuNumericalCode() {
        return uNumericalCode;
    }

    public void setuNumericalCode(String uNumericalCode) {
        this.uNumericalCode = uNumericalCode;
    }

    @Basic
    @Column(name = "Continent")
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Basic
    @Column(name = "SecondaryContinent")
    public String getSecondaryContinent() {
        return secondaryContinent;
    }

    public void setSecondaryContinent(String secondaryContinent) {
        this.secondaryContinent = secondaryContinent;
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

        if (countryId != country1.countryId) return false;
        if (country != null ? !country.equals(country1.country) : country1.country != null) return false;
        if (longName != null ? !longName.equals(country1.longName) : country1.longName != null) return false;
        if (domainCode != null ? !domainCode.equals(country1.domainCode) : country1.domainCode != null) return false;
        if (iso2Code != null ? !iso2Code.equals(country1.iso2Code) : country1.iso2Code != null) return false;
        if (iso3Code != null ? !iso3Code.equals(country1.iso3Code) : country1.iso3Code != null) return false;
        if (uNumericalCode != null ? !uNumericalCode.equals(country1.uNumericalCode) : country1.uNumericalCode != null)
            return false;
        if (continent != null ? !continent.equals(country1.continent) : country1.continent != null) return false;
        return secondaryContinent != null ? secondaryContinent.equals(country1.secondaryContinent) : country1.secondaryContinent == null;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (longName != null ? longName.hashCode() : 0);
        result = 31 * result + (domainCode != null ? domainCode.hashCode() : 0);
        result = 31 * result + (iso2Code != null ? iso2Code.hashCode() : 0);
        result = 31 * result + (iso3Code != null ? iso3Code.hashCode() : 0);
        result = 31 * result + (uNumericalCode != null ? uNumericalCode.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        result = 31 * result + (secondaryContinent != null ? secondaryContinent.hashCode() : 0);
        return result;
    }
}
