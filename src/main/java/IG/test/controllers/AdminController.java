package IG.test.controllers;

import IG.test.entity.Car;
import IG.test.entity.User;
import IG.test.service.CarService;
import IG.test.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    private UserService userService;
    private CarService carService;

    @Autowired
    public AdminController(UserService userService, CarService carService){
        this.userService=userService;
        this.carService=carService;
    }

    @GetMapping("/admin")
    public String pageForAdmins (Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "admin:"+ user.getUsername();
    }

    @RequestMapping("/admin/users")
    @ApiOperation(value = "show all users for admin", response = List.class)
    public List<User> getAllUsersForAdmin() {
        return userService.allUsers();
    }

    @RequestMapping("/admin/allCars")
    @ApiOperation(value = "show all cars for admin", response = List.class)
    public List<Car> getAllCarsForAdmin() {
        return carService.getAllCarsForAdmin();
    }

    @GetMapping("/admin/car/{id}")
    @ApiOperation(value = "show car by id", response = Car.class)
    public Car getCarByIdForAdmin(@PathVariable(value = "id") Long id) {
        return carService.getCarByIdForAdmin(id);
    }

    @GetMapping("/admin/car-delete/{id}")
    public  String carDelete (@PathVariable(value = "id") long id, ModelMap modelMap) {
        carService.deleteCarById(id);
        return "redirect:/airplanes";
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