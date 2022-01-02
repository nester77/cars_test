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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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
        UserDetails user = userService.loadUserByUsername(principal.getName());
        return "admin:" + user.getUsername();
    }

//    @RequestMapping("/admin/users")
//    @ApiOperation(value = "show all users for admin", response = List.class)
//    public List<User> getAllUsersForAdmin() {
//        return userService.allUsers();
//    }

//    @RequestMapping("/admin/allCars")
//    @ApiOperation(value = "show all cars for admin", response = List.class)
//    public List<Car> getAllCarsForAdmin() {
//        return carService.getAllCarsForAdmin();
//    }

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
    void newCar(@RequestBody Car newCar) {
        carService.saveEntity(newCar);
    }

    @PutMapping("/admin/car-update")
    @ApiOperation(value = "update car by id")
    void updateCar(@RequestBody Car updateCar){
        carService.saveEntity(updateCar);
    }


    @GetMapping("/admin/allCars/{pageNo}/{pageSize}")
    @ApiOperation(value = "show all cars for admin by page", response = List.class)
    public List<Car> getPaginatedCar(@PathVariable int pageNo, @PathVariable int pageSize) {
        return carService.getAllCarsForAdmin(pageNo, pageSize);
    }

    @GetMapping("/admin/users/{pageNo}/{pageSize}")
    @ApiOperation(value = "show all users for admin by page", response = List.class)
    public List<User> getPaginatedUser(@PathVariable int pageNo, @PathVariable int pageSize) {
        return userService.allUsers(pageNo, pageSize);
    }


    @GetMapping("/admin/Cars")
    Page<Car> getCars(
            @RequestParam Optional<Integer> pageNo,
            @RequestParam Optional<Integer> pageSize,
            @RequestParam Optional<String> sortBy
    ) {
        return carService.getAllCarsForAdmin2(
                PageRequest.of(
                        pageNo.orElse(0),
                        pageSize.orElse(5),
                        Sort.Direction.ASC,
                        sortBy.orElse("id")
                )

        );
    }

    @GetMapping
    public ResponseEntity<Page<Car>> getEmployees(CarPage carPage,
                                                  CarSearchCriteria carSearchCriteria){
        return new ResponseEntity<>(carService.getAllCarsForAdmin3(carPage, carSearchCriteria),
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