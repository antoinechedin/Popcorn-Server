package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "distributor")
public class Distributor {
    private int distributorId;
    private String distributionCompany;

    @Id
    @Column(name = "DistributorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    @Basic
    @Column(name = "DistributionCompany")
    public String getDistributionCompany() {
        return distributionCompany;
    }

    public void setDistributionCompany(String distributionCompany) {
        this.distributionCompany = distributionCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distributor that = (Distributor) o;

        if (distributorId != that.distributorId) return false;
        return distributionCompany != null ? distributionCompany.equals(that.distributionCompany) : that.distributionCompany == null;
    }

    @Override
    public int hashCode() {
        int result = distributorId;
        result = 31 * result + (distributionCompany != null ? distributionCompany.hashCode() : 0);
        return result;
    }
}
