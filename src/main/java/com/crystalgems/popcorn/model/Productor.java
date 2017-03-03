package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Productor {
    private int productorsId;
    private String productorCompany;

    @Id
    @Column(name = "ProductorsId")
    public int getProductorsId() {
        return productorsId;
    }

    public void setProductorsId(int productorsId) {
        this.productorsId = productorsId;
    }

    @Basic
    @Column(name = "ProductorCompany")
    public String getProductorCompany() {
        return productorCompany;
    }

    public void setProductorCompany(String productorCompany) {
        this.productorCompany = productorCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Productor productor = (Productor) o;

        if (productorsId != productor.productorsId) return false;
        return productorCompany != null ? productorCompany.equals(productor.productorCompany) : productor.productorCompany == null;
    }

    @Override
    public int hashCode() {
        int result = productorsId;
        result = 31 * result + (productorCompany != null ? productorCompany.hashCode() : 0);
        return result;
    }
}
