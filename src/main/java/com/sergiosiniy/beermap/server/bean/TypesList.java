package com.sergiosiniy.beermap.server.bean;

import com.sergiosiniy.beermap.server.entity.BeerType;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="types")
public class TypesList {

    private int count;
    private List<BeerType> types;

    public TypesList() {}

    public TypesList(List<BeerType> types) {
        this.types = types;
        this.count = types.size();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlElement(name="type")
    public List<BeerType> getTypes() {
        return types;
    }
    public void setTypes(List<BeerType> types) {
        this.types = types;
    }

}
