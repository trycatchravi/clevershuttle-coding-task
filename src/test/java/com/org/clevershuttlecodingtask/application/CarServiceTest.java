package com.org.clevershuttlecodingtask.application;

import com.org.clevershuttlecodingtask.infrastructure.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.org.clevershuttlecodingtask.helper.DataGenerator.buildCarEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService(carRepository);
    }

    @Test
    void saveCar() {
        // GIVEN
        when(carRepository.save(any())).thenReturn(buildCarEntity());

        // WHEN THEN
        assertEquals(1L,carService.saveCar(buildCarEntity()).getId());
    }

    @Test
    void getAllCars() {
        // GIVEN
        when(carRepository.findAll()).thenReturn(List.copyOf(Arrays.asList(buildCarEntity())));

        // WHEN THEN
        assertEquals(1, carService.getAllCars().size());
    }

    @Test
    void getCarById() {
        // GIVEN
        when(carRepository.findById(any())).thenReturn(Optional.ofNullable(buildCarEntity()));

        // WHEN THEN
        assertEquals(1L, carService.findById(1L).getId());
    }
}