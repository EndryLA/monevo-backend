package com.monevo.monevo.repositories;

import com.monevo.monevo.models.Category;
import com.monevo.monevo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByUser(User user);

}
