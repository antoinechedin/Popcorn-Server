package com.crystalgems.popcorn.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "moviereleasedate")
public class Moviereleasedate {
    private int moveiReleaseDateLink;
    private int movieId;
    private int countryId;
    private String releaseDate;
    private Date releaseYear;
    private String releaseInfo;

    @Id
    @Column(name = "MoveiReleaseDateLink")
    public int getMoveiReleaseDateLink() {
        return moveiReleaseDateLink;
    }

    public void setMoveiReleaseDateLink(int moveiReleaseDateLink) {
        this.moveiReleaseDateLink = moveiReleaseDateLink;
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
    @Column(name = "CountryId")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "ReleaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "ReleaseYear")
    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "ReleaseInfo")
    public String getReleaseInfo() {
        return releaseInfo;
    }

    public void setReleaseInfo(String releaseInfo) {
        this.releaseInfo = releaseInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviereleasedate that = (Moviereleasedate) o;

        if (moveiReleaseDateLink != that.moveiReleaseDateLink) return false;
        if (movieId != that.movieId) return false;
        if (countryId != that.countryId) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (releaseYear != null ? !releaseYear.equals(that.releaseYear) : that.releaseYear != null) return false;
        return releaseInfo != null ? releaseInfo.equals(that.releaseInfo) : that.releaseInfo == null;
    }

    @Override
    public int hashCode() {
        int result = moveiReleaseDateLink;
        result = 31 * result + movieId;
        result = 31 * result + countryId;
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (releaseInfo != null ? releaseInfo.hashCode() : 0);
        return result;
    }
}
