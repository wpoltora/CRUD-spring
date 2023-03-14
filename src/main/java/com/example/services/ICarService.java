package com.example.services;

import com.example.model.Car;

import java.util.List;

public interface ICarService {
    Car getCarById(int id);
    void updateCar(Car car);
    void deleteCar(int id);
    void addCar(Car car);
    List<Car> getAllCars();
}