package com.cars.Service;


import com.cars.CarDto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

     List<CarDto> findAll();

     Optional<CarDto> findById(Long id);

     CarDto save(CarDto car);

     void deleteById(Long id);

     List<CarDto> findAllMinPrice(int number);

}
