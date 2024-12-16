package com.monevo.monevo.services;

import com.monevo.monevo.models.User;
import com.monevo.monevo.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;

    public AuthenticationService(
            JwtService jwtService,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authManager) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
    }

    public User register(User user) {
        User userToSave = new User();

        userToSave.setEmail(user.getEmail());
        userToSave.setUsername(user.getUsername());
        userToSave.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(userToSave);

    }

    public String login(User user) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateJwtToken(user);
        } else {
            return "failed authentication";
        }
    }
}
