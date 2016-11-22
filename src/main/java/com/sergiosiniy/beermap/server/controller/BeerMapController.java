package com.sergiosiniy.beermap.server.controller;


import com.sergiosiniy.beermap.server.entity.Beer;
import com.sergiosiniy.beermap.server.entity.BeerType;
import com.sergiosiniy.beermap.server.repository.BeerRepository;
import com.sergiosiniy.beermap.server.repository.BeerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping
public class BeerMapController {

    @Autowired
    private BeerTypeRepository beerTypeRepository;
    @Autowired
    private BeerRepository beerRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/beersearch")
    @ResponseBody
    public List<Beer> getSortedBeers(@RequestParam(value="search") String string ){
        return beerRepository.findAll(new Iterable<Long>() {
            public Iterator<Long> iterator() {
                return null;
            }
        });
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
