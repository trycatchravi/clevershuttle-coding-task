package com.org.clevershuttlecodingtask.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.clevershuttlecodingtask.application.CarService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.MediaType;

import static com.org.clevershuttlecodingtask.helper.DataGenerator.buildCarEntity;
import static com.org.clevershuttlecodingtask.helper.DataGenerator.buildCarRequest;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerIntegrationTest {

    private static final String BASE_PATH = "/car";
    private static final String FIND_BY_ID_PATH = "/car/findById";

    @MockBean
    private CarService carService;

    @Mock
    private ObjectMapper objectMapper;

    @Autowired
    private ServletWebServerApplicationContext server;

   @LocalServerPort
   private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void saveCar() throws Exception {
        RestAssured.with().
                contentType(MediaType.APPLICATION_JSON_VALUE).
                body(buildCarRequest()).
                when().
                request("POST",BASE_PATH).
                then().
                statusCode(201);
    }

    @Test
    void getAllCars() {
        RestAssured.given()
                .when()
                .get(BASE_PATH)
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    void getCarById() {
        when(carService.findById(1L)).thenReturn(buildCarEntity());

        RestAssured.given()
                .param("id",1L)
                .when()
                .get(FIND_BY_ID_PATH)
                .then()
                .assertThat().statusCode(200);
    }


}