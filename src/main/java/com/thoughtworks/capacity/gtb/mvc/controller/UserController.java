package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.controller.responseDTO.UserLoginDTO;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody @Valid User user) {
        userService.register(user);
    }

    @GetMapping("/getAllUsers")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<User> getAllUsers() {
        return new ArrayList<>(userService.getUsers());
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserLoginDTO login(@RequestParam(name = "username", required = false) String username,
                              @RequestParam(name = "password", required = false) String password) {
        User user = userService.login(username, password);
        return new UserLoginDTO(userService.findIdbyUser(user), user);
    }

}
