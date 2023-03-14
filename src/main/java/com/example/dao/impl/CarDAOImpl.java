package com.example.dao.impl;

import com.example.dao.ICarDAO;
import com.example.model.Car;
import com.example.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class CarDAOImpl implements ICarDAO {

    @Autowired
    CarRepository carRepository;

    @Override
    public Car getCarById(int id) {
       return carRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}