package com.monevo.monevo.controllers;

import com.monevo.monevo.models.User;
import com.monevo.monevo.services.JwtService;
import com.monevo.monevo.services.UserService;
import io.jsonwebtoken.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;

    }

    @GetMapping("")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }


    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Integer userId){
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }


}
