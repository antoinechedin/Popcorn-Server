package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "currency")
public class Currency {
    private int currencyId;
    private String currency;
    private float conversionUsd;

    @Id
    @Column(name = "CurrencyId")
    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    @Basic
    @Column(name = "Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "ConversionUSD")
    public float getConversionUsd() {
        return conversionUsd;
    }

    public void setConversionUsd(float conversionUsd) {
        this.conversionUsd = conversionUsd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency1 = (Currency) o;

        if (currencyId != currency1.currencyId) return false;
        if (Float.compare(currency1.conversionUsd, conversionUsd) != 0) return false;
        return currency != null ? currency.equals(currency1.currency) : currency1.currency == null;
    }

    @Override
    public int hashCode() {
        int result = currencyId;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (conversionUsd != +0.0f ? Float.floatToIntBits(conversionUsd) : 0);
        return result;
    }
}
