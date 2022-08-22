### Description
* This service implemented the Rest API read and write operations for car.

### Run
Run application by running these commands.
* mvn clean install
* mvn spring-boot:run

### Test
All endpoints can be tested at this swagger URL http://localhost:8080/swagger-ui/index.html 
* POST `/car` endpoint save care details. Below is the sample request.

    `{
      "brand": "MER-S",
      "licensePlate": "L-13407",
      "manufacturer": "MERCEDES",
      "operationCity": "Berlin",
      "status": "AVAILABLE",
      "createdAt": "2022-08-22T19:52:34.554Z",
      "lastUpdatedAt": "2022-08-22T19:52:34.554Z"
      }`

* GET `/car`  endpoint returns all the saved cars.
* GET `/car/findById?id={}` endpoint find single car based on its id.

### Tech Stack
* Java 17
* Spring Boot 2.7.3
* lombok
* H2 DB
* Apache Maven 3.8.5
* OpenApi 1.6.9
* rest-assured 5.1.1
* Javafaker 1.0.2

### Improvements
* If I get some more time, I will implement more test cases to handle negative scenarios.

### Who do I talk to? ###
* if you are not able to run or test the application, please contact me at bains.rk13@gmail.com