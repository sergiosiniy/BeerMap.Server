package com.sergiosiniy.beermap.server.controller;


import com.sergiosiniy.beermap.server.bean.BeersList;
import com.sergiosiniy.beermap.server.bean.TypesList;
import com.sergiosiniy.beermap.server.entity.Beer;
import com.sergiosiniy.beermap.server.entity.BeerType;
import com.sergiosiniy.beermap.server.repository.BeerRepository;
import com.sergiosiniy.beermap.server.repository.BeerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class BeerMapController {

    @Autowired
    private BeerTypeRepository beerTypeRepository;
    @Autowired
    private BeerRepository beerRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/beersearch")
    @ResponseBody
    public BeersList getBeersByStringSearch(@RequestParam(value="str") String string ){
        List<Beer> searchedBeers = beerRepository.findAll();
        List<Beer> list = new ArrayList<Beer>();
        if(string.contains("%20")){
            string = string.replace("%20"," ");
        }
        for(Beer beer:searchedBeers){
            if(beer.getBeerBrand().toLowerCase().equals(string.toLowerCase())||
                    beer.getBeerBrand().toLowerCase().contains(string.toLowerCase())){
                list.add(beer);
            }
        }

        return new BeersList(list);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/typesearch")
    @ResponseBody
    public TypesList getBeerTypesByStingSearch(@RequestParam(value="str") String string ){

        List<BeerType> searchedTypes = beerTypeRepository.findAll();
        List<BeerType> list = new ArrayList<BeerType>();
        if(string.contains("%20")){
            string = string.replace("%20"," ");
        }
        for(BeerType beerType:searchedTypes){
            if(beerType.getBeerType().toLowerCase().equals(string.toLowerCase())||
                    beerType.getBeerType().toLowerCase().contains(string.toLowerCase())){
                list.add(beerType);
            }
        }

        return new TypesList(list);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/type")
    @ResponseBody
    public BeerType getSelectedType(@RequestParam(value="id") long id){
        return beerTypeRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/beer")
    @ResponseBody
    public Beer getSelectedBeer(@RequestParam(value="id") long id){
        return beerRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/types")
    @ResponseBody
    public TypesList getAllTypes(){
        return new TypesList(beerTypeRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/beers")
    @ResponseBody
    public BeersList getAllBeers(){
        return new BeersList(beerRepository.findAll());
    }

}
