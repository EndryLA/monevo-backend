package com.monevo.monevo.controllers;


import com.monevo.monevo.models.Transaction;
import com.monevo.monevo.services.TransactionService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("")
    public List<Transaction> getTransactions() {
            return transactionService.getTransactions();
    }

    @GetMapping("/{transactionId}")
    public Transaction getTransaction(@PathVariable("transactionId") Integer transactionId){
            return transactionService.getTransaction(transactionId);
    }

    @PostMapping("")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @PutMapping("/{userId}")
    public Transaction updateTransaction(@RequestBody Transaction transaction, @PathVariable Integer userId){
        return transactionService.updateTransaction(transaction, userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteTransaction(@PathVariable Integer userId) {
        transactionService.deleteTransaction(userId);
    }



}
