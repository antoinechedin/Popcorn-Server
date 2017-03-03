package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Movielocation {
    private int movieLocationLinkId;
    private int movieId;
    private String location;
    private int zoneId;
    private String locationInfo;

    @Id
    @Column(name = "MovieLocationLinkId")
    public int getMovieLocationLinkId() {
        return movieLocationLinkId;
    }

    public void setMovieLocationLinkId(int movieLocationLinkId) {
        this.movieLocationLinkId = movieLocationLinkId;
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
    @Column(name = "Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "ZoneId")
    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    @Basic
    @Column(name = "LocationInfo")
    public String getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movielocation that = (Movielocation) o;

        if (movieLocationLinkId != that.movieLocationLinkId) return false;
        if (movieId != that.movieId) return false;
        if (zoneId != that.zoneId) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return locationInfo != null ? locationInfo.equals(that.locationInfo) : that.locationInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieLocationLinkId;
        result = 31 * result + movieId;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + zoneId;
        result = 31 * result + (locationInfo != null ? locationInfo.hashCode() : 0);
        return result;
    }
}
