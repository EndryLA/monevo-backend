package com.monevo.monevo.services;

import com.monevo.monevo.models.Transaction;
import com.monevo.monevo.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransaction(Integer transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("transaction not found with id of " + transactionId));
    }

    public String addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);

        return "Transaction enregistrée";
    }

    public String deleteTransaction(Integer transactionId) {
        transactionRepository.deleteById(transactionId);

        return "Transaction supprimée";
    }
}
