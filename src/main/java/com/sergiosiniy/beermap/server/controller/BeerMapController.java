package com.sergiosiniy.beermap.server.controller;


import com.sergiosiniy.beermap.server.entity.Beer;
import com.sergiosiniy.beermap.server.entity.BeerType;
import com.sergiosiniy.beermap.server.repository.BeerRepository;
import com.sergiosiniy.beermap.server.repository.BeerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
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
    public List<Beer> getBeersBysStringSearch(@RequestParam(value="str") String string ){
        List<Beer> searchedBeers = beerRepository.findAll();
        List<Beer> result = new ArrayList<Beer>();
        for(Beer beer:searchedBeers){
            if(beer.getBeerBrand().toLowerCase().equals(string.toLowerCase())||
                    beer.getBeerBrand().toLowerCase().contains(string.toLowerCase())){
                result.add(beer);
            }
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/typesearch")
    @ResponseBody
    public List<BeerType> getBeerTypesByStingSearch(@RequestParam(value="str") String string ){
        List<BeerType> searchedTypes = beerTypeRepository.findAll();
        List<BeerType> result = new ArrayList<BeerType>();
        for(BeerType beerType:searchedTypes){
            if(beerType.getBeerType().toLowerCase().equals(string.toLowerCase())||
                    beerType.getBeerType().toLowerCase().contains(string.toLowerCase())){
                result.add(beerType);
            }
        }
        return result;
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
    public List<BeerType> getAllTypes(){
        return beerTypeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/beers")
    @ResponseBody
    public List<Beer> getAllBeers(){
        return beerRepository.findAll();
    }

}
