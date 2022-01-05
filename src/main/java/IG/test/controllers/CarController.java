package IG.test.controllers;


import IG.test.entity.Car;
import IG.test.entity.CarPage;
import IG.test.entity.CarSearchCriteria;
import IG.test.entity.User;
import IG.test.service.CarService;
import IG.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Api
public class CarController {
    private CarService carService;
    private UserService userService;

    public CarController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping("/")
    @ApiOperation(value = "car sales website")
    public String homePage() {
        return "car sales website";
    }

    @GetMapping("/user")
    @ApiOperation(value = "user page")
    public String pageForUsers(Principal principal) {
        UserDetails user = userService.loadUserByUsername(principal.getName());
        return "user:" + user.getUsername();
    }

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
