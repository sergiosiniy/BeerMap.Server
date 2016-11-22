package com.sergiosiniy.beermap.server.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "beers_table")
public class Beer {

    public Beer(){

    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long _id;
    @Column(name = "beer_brand", nullable = false)
    private String beerBrand;
    /*@Column(name = "beer_img")
    private int beerImage;*/
    @Column(name = "beer_descr")
    private String beerDescription;
    @Column(name = "type_id", nullable = false)
    private String beerType;


    public long get_id() {
        return _id;
    }

    public String getBeerBrand() {
        return beerBrand;
    }

    public String getBeerType() {
        return beerType;
    }

    public String getBeerDescription() {
        return beerDescription;
    }
   /* public int getBeerImage() {
        return beerImage;
    }*/


    /*public void setBeerImage(int beerImage) {
        this.beerImage = beerImage;
    }*/

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setBeerBrand(String beerBrand) {
        this.beerBrand = beerBrand;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }
}
