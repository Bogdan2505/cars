package com.cars.Service;

import com.cars.CarDto.CountryDto;
import com.cars.persist.Country;

import java.util.List;

public interface CountryService {

    List<CountryDto> findAll();
}
