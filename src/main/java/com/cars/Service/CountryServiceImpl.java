package com.cars.Service;

import com.cars.CarDto.CarDto;
import com.cars.CarDto.CountryDto;
import com.cars.persist.Car;
import com.cars.persist.CarRepository;
import com.cars.persist.Country;
import com.cars.persist.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService{


    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<CountryDto> findAll() {
        return countryRepository.findAll().stream()
                .map(com.cars.Service.CountryServiceImpl::countryToDto).collect(Collectors.toList());
    }

    private static CountryDto countryToDto(Country country) {
        return new CountryDto(country.getId(), country.getTitle());
    }

}
