package com.org.clevershuttlecodingtask.application;

import com.org.clevershuttlecodingtask.domain.model.Car;
import com.org.clevershuttlecodingtask.exception.ResourceNotFoundException;
import com.org.clevershuttlecodingtask.infrastructure.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return Optional.ofNullable(carRepository.findAll()).orElseThrow(() -> new ResourceNotFoundException(String.format("There is no car added")));
    }

    public Car findById(Long id) {
       return carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Car details not found for id: %s", id)));
    }

}
