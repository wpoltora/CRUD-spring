package com.example.services.impl;

import com.example.dao.ICarDAO;
import com.example.model.Car;
import com.example.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    ICarDAO carDAO;

    @Override
    public Car getCarById(int id) {
        return this.carDAO.getCarById(id);
    }

    @Override
    public void updateCar(Car car) {
        Car  DBCar = this.carDAO.getCarById(car.getId());
        DBCar.setId(car.getId());
        DBCar.setName(car.getName());
        DBCar.setAge(car.getAge());
        DBCar.setBrand(car.getBrand());
        DBCar.setColor(car.getColor());
        DBCar.setTopSpeed(car.getTopSpeed());
        this.carDAO.updateCar(DBCar);
    }

    @Override
    public void deleteCar(int id){
        this.carDAO.deleteCar(id);
    }

    @Override
    public void addCar(Car car){
        this.carDAO.addCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return this.carDAO.getAllCars();
    }
}
