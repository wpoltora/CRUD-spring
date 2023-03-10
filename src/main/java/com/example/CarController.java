package com.example;

import com.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping("/addcar")
    public String showAddCarForm(Car car) {
        return "add-car";
    }


    @PostMapping("/addcar")
    public String addCar(@Valid Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-car";
        }

        carRepository.save(car);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showCarList(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));

        model.addAttribute("car", car);
        return "update-car";
    }

    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable("id") int id, @Valid Car car,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            car.setId(id);
            return "update-car";
        }

        carRepository.save(car);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") int id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        carRepository.delete(car);
        return "redirect:/index";
    }
}
