package com.org.clevershuttlecodingtask.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.clevershuttlecodingtask.application.CarService;
import com.org.clevershuttlecodingtask.domain.model.Car;
import com.org.clevershuttlecodingtask.rest.dto.CarDto;
import com.org.clevershuttlecodingtask.rest.request.CarRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
@Tag(name = "Car Service")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final ObjectMapper objectMapper;

    @Operation(summary = "Save car details")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto> saveCar(@Valid @RequestBody CarRequest carRequest) {
           Car car = carService.saveCar(convertRequestToEntity(carRequest));
           return ResponseEntity.status(HttpStatus.CREATED).body(convertEntityToDto(car));
    }

    @Operation(summary = "Get all cars")
    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(convertListEntityToDto(cars));
    }

    @Operation(summary = "Get single car by id")
    @GetMapping(value = "/findById")
    public ResponseEntity<CarDto> findById(@RequestParam Long id) {
        Car car = carService.findById(id);
        return ResponseEntity.ok(convertEntityToDto(car));
    }

    private Car convertRequestToEntity(CarRequest carRequest) {
        return objectMapper.convertValue(carRequest, Car.class);
    }

    private CarDto convertEntityToDto(Car car){
        return objectMapper.convertValue(car,CarDto.class);
    }

    private List<CarDto> convertListEntityToDto(List<Car> cars){
        return cars.stream().map(car -> convertEntityToDto(car)).collect(Collectors.toList());
    }

}
