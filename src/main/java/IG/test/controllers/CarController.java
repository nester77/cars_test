package IG.test.controllers;


import IG.test.entity.Car;
import IG.test.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @RequestMapping("/allCars")
    public List<Car> getAllCarsForAdmin() {
        return carService.getAllCar();
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable(value = "id") Long id) {
        return carService.getCarById(id);
    }
}
