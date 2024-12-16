package com.monevo.monevo.repositories;

import com.monevo.monevo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);

    public User findByEmail(String email);

}
