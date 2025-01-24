package com.example.rentalService.web;

public class Car {
    private String plateNumber;
    private String brand;
    private int price;
    private boolean rented;

    // Constructeur
    public Car(String plateNumber, String brand, int price, boolean rented) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rented = rented;
    }

    // Getters et setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", rented=" + rented +
                '}';
    }
}
