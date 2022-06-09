package com.cars.Service;

import com.cars.CarDto.CarCountryDto;
import com.cars.persist.CarCountry;
import com.cars.persist.CarCountryRepository;
import com.cars.persist.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarCountryServiceImpl implements CarCountryService{

    private final CarCountryRepository carCountryRepository;

    @Autowired
    public CarCountryServiceImpl(CarCountryRepository carCountryRepository) {
        this.carCountryRepository = carCountryRepository;
    }

    @Override
    public List<CarCountryDto> innerJoin() {
        return carCountryRepository.innerJoin().stream()
                .map(CarCountryServiceImpl::carCountryToDto).collect(Collectors.toList());
    }

    private static CarCountryDto carCountryToDto(CarCountry carCountry) {
        return new CarCountryDto(carCountry.getId(), carCountry.getTitle(),
                carCountry.getModel(), carCountry.getPrice(), carCountry.getCountryCreator(),
                carCountry.getYearCreator(),carCountry.getContinentId(), carCountry.getCrId(), carCountry.getContinent());
    }
}
