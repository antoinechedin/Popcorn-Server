package com.crystalgems.popcorn.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "linktype")
public class Linktype {
    private int id;
    private String linkType;

    @Id
    @Column(name = "LinkTypeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int linkTypeId) {
        this.id = linkTypeId;
    }

    @Basic
    @Column(name = "LinkType")
    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linktype linktype = (Linktype) o;
        return Objects.equals(linkType, linktype.linkType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkType);
    }
}
