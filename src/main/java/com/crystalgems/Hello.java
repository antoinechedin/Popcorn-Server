package com.crystalgems;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Antoine on 02/03/2017.
 */
@XmlRootElement
public class Hello {
    private String text;
    private int id;

    public Hello() {
        text = "Hello World!";
        id = (int) (Math.random()*100);
    }
}
