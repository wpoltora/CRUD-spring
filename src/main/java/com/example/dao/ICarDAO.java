package com.example.dao;

import com.example.model.Car;

import java.util.List;

public interface ICarDAO {
    Car getCarById(int id);
    void updateCar(Car car);
    void deleteCar(int id);
    void addCar(Car car);
    List<Car> getAllCars();
}
