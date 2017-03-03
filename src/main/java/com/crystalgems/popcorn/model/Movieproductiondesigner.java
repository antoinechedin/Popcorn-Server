package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "movieproductiondesigner")
public class Movieproductiondesigner {
    private int movieProductionDesignerLinkId;
    private int movieId;
    private int productionDesignerId;
    private String productionInfo;

    @Id
    @Column(name = "MovieProductionDesignerLinkId")
    public int getMovieProductionDesignerLinkId() {
        return movieProductionDesignerLinkId;
    }

    public void setMovieProductionDesignerLinkId(int movieProductionDesignerLinkId) {
        this.movieProductionDesignerLinkId = movieProductionDesignerLinkId;
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
    @Column(name = "ProductionDesignerId")
    public int getProductionDesignerId() {
        return productionDesignerId;
    }

    public void setProductionDesignerId(int productionDesignerId) {
        this.productionDesignerId = productionDesignerId;
    }

    @Basic
    @Column(name = "ProductionInfo")
    public String getProductionInfo() {
        return productionInfo;
    }

    public void setProductionInfo(String productionInfo) {
        this.productionInfo = productionInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movieproductiondesigner that = (Movieproductiondesigner) o;

        if (movieProductionDesignerLinkId != that.movieProductionDesignerLinkId) return false;
        if (movieId != that.movieId) return false;
        if (productionDesignerId != that.productionDesignerId) return false;
        return productionInfo != null ? productionInfo.equals(that.productionInfo) : that.productionInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieProductionDesignerLinkId;
        result = 31 * result + movieId;
        result = 31 * result + productionDesignerId;
        result = 31 * result + (productionInfo != null ? productionInfo.hashCode() : 0);
        return result;
    }
}
