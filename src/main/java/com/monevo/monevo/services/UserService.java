package com.monevo.monevo.services;

import com.monevo.monevo.models.User;
import com.monevo.monevo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer userId) {

        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, Integer userId) {
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not foud"));
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());

        return userRepository.save(userToUpdate);
    }

    public String deleteUser(Integer userId) {
        userRepository.deleteById(userId);
        return "Utilisateur supprimé";
    }




}
