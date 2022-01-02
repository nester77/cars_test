package IG.test.controllers;


import IG.test.entity.Car;
import IG.test.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


//    @RequestMapping("/allCars")
//    @ApiOperation(value = "show all cars for user", response = List.class)
//    public List<Car> getAllCars() {
//        return carService.getAllCarsForUser();
//    }

    @GetMapping("/allCars/{pageNo}/{pageSize}")
    @ApiOperation(value = "show all cars for user by page", response = List.class)
    public List <Car> getPaginatedCar(@PathVariable int pageNo, @PathVariable int pageSize){
        return carService.getAllCarsForUser(pageNo, pageSize);
    }



    @GetMapping("/car/{id}")
    @ApiOperation(value = "show car by id for user", response = Car.class)
    public Object getCarById(@PathVariable(value = "id") Long id) {
        return carService.getCarByIdForUser(id);
    }



}
