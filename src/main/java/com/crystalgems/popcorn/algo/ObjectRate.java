package com.crystalgems.popcorn.algo;

import java.util.Objects;

/**
 * Created by Antoine on 27/03/2017.
 */
public class ObjectRate<T> implements Comparable {
    private T object;
    private double rate;

    public ObjectRate(T object) {
        this.object = object;
        this.rate = 1;
    }

    public ObjectRate(T object, double weight) {
        this.object = object;
        rate = weight;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void increaseCounter(double weight) {
        this.rate += weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectRate<?> that = (ObjectRate<?>) o;
        return Objects.equals(object, that.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof ObjectRate) {
            ObjectRate objectRate = (ObjectRate) o;
            if (rate - objectRate.rate > 0) return -1;
            if (rate - objectRate.rate < 0) return 1;
            return 0;
        } else
            throw new RuntimeException();
    }
}
