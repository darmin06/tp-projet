package com.example.rentalService.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RentalWebService {

    private final RentalService rentalService = new RentalService();
    Logger logger = LoggerFactory.getLogger(RentalWebService.class);

    @GetMapping("/cars")
    public List<Car> listOfCars() {
        return rentalService.getAvailableCars();
    }

   
    @GetMapping("/cars/all")
    public List<Car> listAllCars() {
        return rentalService.getAllCars();
    }

    
    @GetMapping("/cars/{plateNumber}")
    public Car getCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        return rentalService.getCarByPlate(plateNumber);
    }

    
    @PutMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrReturnCar(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent") boolean rent,
            @RequestBody(required = false) Dates dates) throws Exception {

        if (rent) {
            logger.info("Renting car with plate: " + plateNumber + " for dates: " + dates);
            rentalService.rentCar(plateNumber, dates);
        } else {
            logger.info("Returning car with plate: " + plateNumber);
            rentalService.returnCar(plateNumber);
        }
    }
}
