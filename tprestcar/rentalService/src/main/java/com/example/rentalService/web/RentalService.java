package com.example.rentalService.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalService {
    private List<Car> cars;

    // Constructeur pour initialiser les voitures
    public RentalService() {
        cars = new ArrayList<>();
        cars.add(new Car("11AA22", "Ferrari", 100, false)); // Disponible
        cars.add(new Car("33BB44", "Tesla", 120, false));  // Disponible
        cars.add(new Car("55CC66", "Toyota", 80, true));  // Louée
    }

    // Retourne la liste de toutes les voitures
    public List<Car> getAllCars() {
        return cars;
    }

    // Retourne la liste des voitures disponibles (non louées)
    public List<Car> getAvailableCars() {
        return cars.stream().filter(car -> !car.isRented()).collect(Collectors.toList());
    }

    // Retourne une voiture par son numéro de plaque
    public Car getCarByPlate(String plateNumber) throws Exception {
        return cars.stream()
                .filter(car -> car.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElseThrow(() -> new Exception("Car not found!"));
    }

    // Loue une voiture
    public void rentCar(String plateNumber, Dates dates) throws Exception {
        Car car = getCarByPlate(plateNumber);
        if (car.isRented()) {
            throw new Exception("Car is already rented!");
        }
        car.setRented(true);
    }

    // Retourne une voiture
    public void returnCar(String plateNumber) throws Exception {
        Car car = getCarByPlate(plateNumber);
        if (!car.isRented()) {
            throw new Exception("Car is not rented!");
        }
        car.setRented(false);
    }
}
