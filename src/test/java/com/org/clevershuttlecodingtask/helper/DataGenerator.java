package com.org.clevershuttlecodingtask.helper;

import com.github.javafaker.Faker;
import com.org.clevershuttlecodingtask.domain.model.Car;
import com.org.clevershuttlecodingtask.domain.model.Status;
import com.org.clevershuttlecodingtask.rest.request.CarRequest;

import java.time.Instant;
import java.util.Locale;


public class DataGenerator {
    private static final Faker FAKER = new Faker(Locale.GERMANY);

    public static CarRequest buildCarRequest() {
        return new CarRequest(FAKER.bothify("MERCEDES-###-?"), Faker.instance().bothify("L-######"),
                FAKER.company().name(), FAKER.address().city(), FAKER.options().option(Status.class),
                Instant.now(), Instant.now());
    }

    public static Car buildCarEntity() {
        return Car.builder().
                id(1L).
                brand(FAKER.bothify("MERCEDES-###-?")).
                brand(Faker.instance().bothify("L-######")).
                manufacturer(FAKER.company().name()).
                operationCity(FAKER.address().city()).
                status(FAKER.options().option(Status.class)).
                createdAt(Instant.now()).
                lastUpdatedAt(Instant.now()).
                build();
    }

}
