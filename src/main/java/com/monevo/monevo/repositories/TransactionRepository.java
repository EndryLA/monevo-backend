package com.monevo.monevo.repositories;

import com.monevo.monevo.models.Category;
import com.monevo.monevo.models.Transaction;
import com.monevo.monevo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByUser(User user);
    List<Transaction> findByUserAndCategory(User user, Category category);
}
