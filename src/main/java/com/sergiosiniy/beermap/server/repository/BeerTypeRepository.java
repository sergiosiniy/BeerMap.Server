package com.sergiosiniy.beermap.server.repository;


import com.sergiosiniy.beermap.server.entity.BeerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerTypeRepository extends JpaRepository<BeerType, Long> {
}
