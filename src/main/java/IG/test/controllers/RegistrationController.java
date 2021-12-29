package IG.test.controllers;

import IG.test.entity.User;
import IG.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "user registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

//    @GetMapping("/registration")
//    @ApiOperation(value = "user registration")
//    public Model registration(Model model) {
//        return model.addAttribute("userForm", new User());
//
//
//    }
//
//    @PostMapping("/registration")
//    @ApiOperation(value = "add user")
//    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "registration";
//        }
//        if (!userService.saveUser(userForm)){
//            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
//            return "registration";
//        }
//
//        return "/allCars";
//    }
}
