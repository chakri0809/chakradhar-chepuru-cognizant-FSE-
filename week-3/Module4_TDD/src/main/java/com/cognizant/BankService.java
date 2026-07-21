package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankService {
    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

    public void processTransaction(String accountId, double amount) {
        logger.info("Starting transaction for account: {}", accountId);
        logger.info("Transaction amount: {}", amount);

        if (amount <= 0) {
            logger.error("Invalid transaction amount: {}", amount);
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > 100000) {
            logger.warn("Large transaction detected for account: {}", accountId);
        }

        logger.debug("Processing transaction details for account: {}", accountId);
        logger.info("Transaction processed successfully for account: {}", accountId);
    }

    public void deleteAccount(String accountId) {
        logger.warn("Deleting account: {}", accountId);
        logger.info("Account deleted successfully: {}", accountId);
    }

    public void login(String username, String password) {
        logger.info("Login attempt for user: {}", username);

        if (username == null || username.isEmpty()) {
            logger.error("Username is empty");
            throw new IllegalArgumentException("Username is required");
        }

        if (password == null || password.length() < 6) {
            logger.error("Password is too short");
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }

        logger.info("Login successful for user: {}", username);
    }

    public static void main(String[] args) {
        BankService service = new BankService();

        try {
            service.processTransaction("ACC1001", 5000.0);
            service.processTransaction("ACC1002", 200000.0);
            service.processTransaction("ACC1003", -10.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Handled invalid transaction: " + e.getMessage());
        }

        service.deleteAccount("ACC1004");

        try {
            service.login("rahul", "pass123");
            service.login("", "short");
        } catch (IllegalArgumentException e) {
            System.out.println("Handled login error: " + e.getMessage());
        }
    }
}
