package com.crystalgems.popcorn.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "productor")
public class Productor {
    private int id;
    private String productorCompany;

    @Id
    @Column(name = "ProductorsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int productorsId) {
        this.id = productorsId;
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
        return Objects.equals(productorCompany, productor.productorCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productorCompany);
    }
}
