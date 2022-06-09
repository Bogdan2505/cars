package com.cars.Service;


import com.cars.CarDto.CarCountryDto;
import com.cars.CarDto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

     List<CarDto> findAll();

     Optional<CarDto> findById(Long id);

     CarDto save(CarDto car);

     void deleteById(Long id);

     List<CarDto> findAllMinBoundPrice(int number);

     List<CarDto> findAllMaxBoundPrice(int number);

     List<CarDto> findAllEqualsPrice(int number);

     List<CarDto> findAllBetween(int numberMin, int numberMax);

     List<CarDto> findAllSortDesc();

     List<CarDto> findAllGroupBy();



}
