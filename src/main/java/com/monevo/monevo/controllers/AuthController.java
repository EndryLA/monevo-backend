package com.monevo.monevo.controllers;

import com.monevo.monevo.models.User;
import com.monevo.monevo.services.AuthenticationService;
import com.monevo.monevo.services.JwtService;
import io.jsonwebtoken.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

   @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authenticationService.register(user);
   }

   @PostMapping("/login")
    public String login(@RequestBody User user) {
        return authenticationService.login(user);
   }

}
