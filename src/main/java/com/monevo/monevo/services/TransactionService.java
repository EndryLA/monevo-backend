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

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);

    }

    public Transaction updateTransaction(Transaction transaction, Integer transactionId) {
        Transaction transactionToUpdate = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not fouNd"));

        transactionToUpdate.setAmount(transaction.getAmount());
        transactionToUpdate.setCategory(transaction.getCategory());
        transactionToUpdate.setDescription(transaction.getDescription());
        transactionToUpdate.setType(transaction.getType());
        transactionToUpdate.setDate(transaction.getDate());
        
        return transactionRepository.save(transactionToUpdate);
    }

    public void deleteTransaction(Integer transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
