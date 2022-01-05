package IG.test.controllers;


import IG.test.entity.Car;
import IG.test.entity.CarPage;
import IG.test.entity.CarSearchCriteria;
import IG.test.entity.User;
import IG.test.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/allCars/{pageNo}/{pageSize}")
//    @ApiOperation(value = "show all cars for user by page", response = List.class)
//    public List <Car> getPaginatedCar(@PathVariable int pageNo, @PathVariable int pageSize){
//        return carService.getAllCarsForUser(pageNo, pageSize);
//    }

    @GetMapping("/cars")
    @ApiOperation(value = "show all valid cars for user with pagination, sorting and filtering", response = User.class)
    public ResponseEntity<Page<Car>> getAllCarsForUser(CarPage carPage,
                                                        CarSearchCriteria carSearchCriteria) {
        return new ResponseEntity<>(carService.getAllCarsForUser(carPage, carSearchCriteria),
                HttpStatus.OK);
    }

    @GetMapping("/car/{id}")
    @ApiOperation(value = "show car by id for user", response = Car.class)
    public Object getCarById(@PathVariable(value = "id") Long id) {
        return carService.getCarByIdForUser(id);
    }



}
