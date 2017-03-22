package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "zone")
public class Zone {
    private int zoneId;
    private String zone;
    private int countryId;

    @Id
    @Column(name = "ZoneId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    @Basic
    @Column(name = "Zone")
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Basic
    @Column(name = "CountryId")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zone zone1 = (Zone) o;

        if (zoneId != zone1.zoneId) return false;
        if (countryId != zone1.countryId) return false;
        return zone != null ? zone.equals(zone1.zone) : zone1.zone == null;
    }

    @Override
    public int hashCode() {
        int result = zoneId;
        result = 31 * result + (zone != null ? zone.hashCode() : 0);
        result = 31 * result + countryId;
        return result;
    }
}
