package com.sergiosiniy.beermap.server.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "beer_types_table")
public class BeerType {

    public BeerType(){

    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long _id;
    @Column(name = "beer_type", nullable = false)
    private String beerType;


    public long get_id() {
        return _id;
    }

    public String getBeerType() {
        return beerType;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }
}
