package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Moviebusiness {
    private int movieId;
    private int budgetCurrencyId;
    private double budget;
    private double budgetUsd;
    private int revenueCurrencyId;
    private double revenue;
    private double revenueUsd;

    @Id
    @Column(name = "MovieId")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "BudgetCurrencyID")
    public int getBudgetCurrencyId() {
        return budgetCurrencyId;
    }

    public void setBudgetCurrencyId(int budgetCurrencyId) {
        this.budgetCurrencyId = budgetCurrencyId;
    }

    @Basic
    @Column(name = "Budget")
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "BudgetUSD")
    public double getBudgetUsd() {
        return budgetUsd;
    }

    public void setBudgetUsd(double budgetUsd) {
        this.budgetUsd = budgetUsd;
    }

    @Basic
    @Column(name = "RevenueCurrencyID")
    public int getRevenueCurrencyId() {
        return revenueCurrencyId;
    }

    public void setRevenueCurrencyId(int revenueCurrencyId) {
        this.revenueCurrencyId = revenueCurrencyId;
    }

    @Basic
    @Column(name = "Revenue")
    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Basic
    @Column(name = "RevenueUSD")
    public double getRevenueUsd() {
        return revenueUsd;
    }

    public void setRevenueUsd(double revenueUsd) {
        this.revenueUsd = revenueUsd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviebusiness that = (Moviebusiness) o;

        if (movieId != that.movieId) return false;
        if (budgetCurrencyId != that.budgetCurrencyId) return false;
        if (Double.compare(that.budget, budget) != 0) return false;
        if (Double.compare(that.budgetUsd, budgetUsd) != 0) return false;
        if (revenueCurrencyId != that.revenueCurrencyId) return false;
        if (Double.compare(that.revenue, revenue) != 0) return false;
        return Double.compare(that.revenueUsd, revenueUsd) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = movieId;
        result = 31 * result + budgetCurrencyId;
        temp = Double.doubleToLongBits(budget);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(budgetUsd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + revenueCurrencyId;
        temp = Double.doubleToLongBits(revenue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(revenueUsd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
