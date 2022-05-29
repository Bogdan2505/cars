package com.cars.Service;

import com.cars.CarDto.CarDto;
import com.cars.persist.Car;
import com.cars.persist.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll().stream()
                .map(CarServiceImpl::carToDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> findAllMinPrice(int number) {
        return carRepository.findAllMinPrice(number).stream()
                .map(CarServiceImpl::carToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<CarDto> findById(Long id) {
       return carRepository.findById(id).map(CarServiceImpl::carToDto);
       /* return carRepository.findBy(id).map(
                CarServiceImpl::carToDto);*/
    }

    @Override
    public CarDto save(CarDto car) {
        return carToDto(carRepository.save(
                new Car(car.getId(),
                        car.getTitle(),
                        car.getModel(),
                        car.getPrice(),
                        car.getCountryCreator(),
                        car.getYearCreator() )));
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }


    private static CarDto carToDto(Car car) {
        return new CarDto(car.getId(), car.getTitle(), car.getModel(), car.getPrice(), car.getCountryCreator(), car.getYearCreator());
    }
}
