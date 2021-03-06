package com.sergiosiniy.beermap.server.repository;


import com.sergiosiniy.beermap.server.entity.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}
