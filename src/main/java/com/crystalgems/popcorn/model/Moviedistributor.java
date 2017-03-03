package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Moviedistributor {
    private int movieDistributorLinkId;
    private int movieId;
    private int distributionCompanyId;
    private String countryCode;
    private String distributionInfo;

    @Id
    @Column(name = "MovieDistributorLinkId")
    public int getMovieDistributorLinkId() {
        return movieDistributorLinkId;
    }

    public void setMovieDistributorLinkId(int movieDistributorLinkId) {
        this.movieDistributorLinkId = movieDistributorLinkId;
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
    @Column(name = "DistributionCompanyId")
    public int getDistributionCompanyId() {
        return distributionCompanyId;
    }

    public void setDistributionCompanyId(int distributionCompanyId) {
        this.distributionCompanyId = distributionCompanyId;
    }

    @Basic
    @Column(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "DistributionInfo")
    public String getDistributionInfo() {
        return distributionInfo;
    }

    public void setDistributionInfo(String distributionInfo) {
        this.distributionInfo = distributionInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviedistributor that = (Moviedistributor) o;

        if (movieDistributorLinkId != that.movieDistributorLinkId) return false;
        if (movieId != that.movieId) return false;
        if (distributionCompanyId != that.distributionCompanyId) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        return distributionInfo != null ? distributionInfo.equals(that.distributionInfo) : that.distributionInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieDistributorLinkId;
        result = 31 * result + movieId;
        result = 31 * result + distributionCompanyId;
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (distributionInfo != null ? distributionInfo.hashCode() : 0);
        return result;
    }
}
