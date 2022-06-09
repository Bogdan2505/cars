package com.cars.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarCountryRepository extends JpaRepository<CarCountry, Long>, JpaSpecificationExecutor<CarCountry> {

    @Query("select c from Car c inner join Country cr on c.continentId = cr.id")
    List<CarCountry> innerJoin();
}
