package com.sergiosiniy.beermap.server.bean;


import com.sergiosiniy.beermap.server.entity.Beer;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="beers")
public class BeersList {

    private int count;
    private List<Beer> beers;

    public BeersList() {}

    public BeersList(List<Beer> beers) {
        this.beers = beers;
        this.count = beers.size();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlElement(name="beer")
    public List<Beer> getBeers() {
        return beers;
    }
    public void setBeers(List<Beer> employees) {
        this.beers = employees;
    }

}
