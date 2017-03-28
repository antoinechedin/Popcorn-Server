package com.crystalgems.popcorn.model;

import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "distributor")
public class Distributor {
    private int id;
    private String distributionCompany;
    private Set<Movie> movies;

    @Id
    @Column(name = "DistributorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int distributorId) {
        this.id = distributorId;
    }

    @Basic
    @Column(name = "DistributionCompany")
    public String getDistributionCompany() {
        return distributionCompany;
    }

    public void setDistributionCompany(String distributionCompany) {
        this.distributionCompany = distributionCompany;
    }

    @ManyToMany
    @JoinTable(
            name = "moviedistributor",
            joinColumns = @JoinColumn(name = "DistributionCompanyId"),
            inverseJoinColumns = @JoinColumn(name = "MovieId")
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
        Distributor that = (Distributor) o;
        return Objects.equals(distributionCompany, that.distributionCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distributionCompany);
    }
}
