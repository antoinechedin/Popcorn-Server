package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Color {
    private int colorId;
    private String color;

    @Id
    @Column(name = "ColorId")
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Basic
    @Column(name = "Color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color1 = (Color) o;

        if (colorId != color1.colorId) return false;
        return color != null ? color.equals(color1.color) : color1.color == null;
    }

    @Override
    public int hashCode() {
        int result = colorId;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
