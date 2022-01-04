package IG.test.controllers;

import IG.test.entity.Car;
import IG.test.entity.CarPage;
import IG.test.entity.CarSearchCriteria;
import IG.test.entity.User;
import IG.test.service.CarService;
import IG.test.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
public class AdminController {

    private UserService userService;
    private CarService carService;


    @Autowired
    public AdminController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;

    }

    @GetMapping("/admin")
    public String pageForAdmins(Principal principal) {
        User user = userService.loadUserByUsername(principal.getName());

        return "admin:" + user.getUsername()+ userService.findRole(user.getId());

    }

    @GetMapping("/admin/car/{id}")
    @ApiOperation(value = "show car by id", response = Car.class)
    public Car getCarByIdForAdmin(@PathVariable(value = "id") Long id) {
        return carService.getCarByIdForAdmin(id);
    }

    @GetMapping("/admin/car-delete/{id}")
    @ApiOperation(value = "delete car by id")
    public String carDelete(@PathVariable(value = "id") long id) {
        carService.deleteCarById(id);
        return "delete car";
    }

    @PostMapping("/admin/car-new")
    @ApiOperation(value = "create new car")
    String createCar(@RequestBody @Valid Car newCar, BindingResult bindingResult) {
        carService.saveEntity(newCar);
        return bindingResult.toString();
    }

    @PutMapping("/admin/car-update")
    @ApiOperation(value = "update car by id")
    String updateCar(@RequestBody @Valid Car updateCar, BindingResult bindingResult) {
        carService.saveEntity(updateCar);
        return bindingResult.toString();
    }


    @GetMapping("/admin/users/{pageNo}/{pageSize}")
    @ApiOperation(value = "show all users for admin by page", response = List.class)
    public List<User> getPaginatedUser(@PathVariable int pageNo, @PathVariable int pageSize) {
        return userService.allUsers(pageNo, pageSize);
    }


    @GetMapping("/admin/cars")
    @ApiOperation(value = "show all cars for admin with pagination, sorting and filtering", response = User.class)
    public ResponseEntity<Page<Car>> getAllCarsForAdmin(CarPage carPage,
                                                        CarSearchCriteria carSearchCriteria) {
        return new ResponseEntity<>(carService.getAllCarsForAdmin(carPage, carSearchCriteria),
                HttpStatus.OK);
    }


//    @PostMapping("/admin")
//    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
//                             @RequestParam(required = true, defaultValue = "") String action,
//                             Model model) {
//        if (action.equals("delete")) {
//            userService.deleteUser(userId);
//        }
//        return "redirect:/admin";
//    }

//    @GetMapping("/admin/gt/{userId}")
//    public String gtUser(@PathVariable("userId") Long userId, Model model) {
//        model.addAttribute("allUsers", userService.usergtList(userId));
//        return "admin";
//    }


    @GetMapping("/admin/users/{id}")
    @ApiOperation(value = "show user by id for admin", response = User.class)
    public User getCarById(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }


//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage(Model model) {
//
//        return "loginPage";
//    }
}