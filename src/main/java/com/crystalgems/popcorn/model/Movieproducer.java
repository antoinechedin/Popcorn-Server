package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "movieproducer")
public class Movieproducer {
    private int movieProducerLinkId;
    private int movieId;
    private int producerId;
    private String producerInfo;

    @Id
    @Column(name = "MovieProducerLinkId")
    public int getMovieProducerLinkId() {
        return movieProducerLinkId;
    }

    public void setMovieProducerLinkId(int movieProducerLinkId) {
        this.movieProducerLinkId = movieProducerLinkId;
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
    @Column(name = "ProducerId")
    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    @Basic
    @Column(name = "ProducerInfo")
    public String getProducerInfo() {
        return producerInfo;
    }

    public void setProducerInfo(String producerInfo) {
        this.producerInfo = producerInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movieproducer that = (Movieproducer) o;

        if (movieProducerLinkId != that.movieProducerLinkId) return false;
        if (movieId != that.movieId) return false;
        if (producerId != that.producerId) return false;
        return producerInfo != null ? producerInfo.equals(that.producerInfo) : that.producerInfo == null;
    }

    @Override
    public int hashCode() {
        int result = movieProducerLinkId;
        result = 31 * result + movieId;
        result = 31 * result + producerId;
        result = 31 * result + (producerInfo != null ? producerInfo.hashCode() : 0);
        return result;
    }
}
