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

        try {
            return transactionService.getTransactions();
        } catch (Exception error){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"error",error);
        }
    }

    @GetMapping("/{transactionId}")
    public Transaction getTransaction(@PathVariable("transactionId") Integer transactionId){
        try {
            return transactionService.getTransaction(transactionId);
        } catch (Exception error) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction introuvable",error);
        }
    }



}
