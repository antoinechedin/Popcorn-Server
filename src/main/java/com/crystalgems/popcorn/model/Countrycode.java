package com.crystalgems.popcorn.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "countrycode")
public class Countrycode {
    private String countryCode;
    private int countryId;

    @Id
    @Column(name = "CountryCode")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
        Countrycode that = (Countrycode) o;
        return Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode);
    }
}
