package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "car")
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    private Integer id;
    private String brand;
    private String name;
    private String color;
    private int age;
    private int topSpeed;

    public Car(String brand, String name, String color, int age, int topSpeed) {
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.age = age;
        this.topSpeed = topSpeed;
    }

    public String getInfo() {
        return "Brand: " + brand + " Name: " + name + " Color: " + color + " Age: " + age + " Top speed: " + topSpeed + "MPH";
    }


    public static class CarBuilder {
        private String brand;
        private String name;
        private String color;
        private int age;
        private int topSpeed;

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public CarBuilder setTopSpeed(int topSpeed) {
            this.topSpeed = topSpeed;
            return this;
        }

        public Car build() {
            return new Car(brand, name, color, age, topSpeed);
        }
    }
}
