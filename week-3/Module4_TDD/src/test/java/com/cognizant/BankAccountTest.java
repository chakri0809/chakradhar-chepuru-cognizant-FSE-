package com.cognizant;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    private BankAccount account;

    @BeforeAll
    static void setUpAll() {
        System.out.println("=== BankAccount Tests Starting ===");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("=== BankAccount Tests Completed ===");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Arrange: creating a new bank account");
        account = new BankAccount("ACC001", "Rahul", 1000.0);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleanup: account set to null");
        account = null;
    }

    @Test
    void testDeposit() {
        System.out.println("Act: deposit 500 and assert balance is 1500");
        account.deposit(500);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void testWithdraw() {
        System.out.println("Act: withdraw 300 and assert balance is 700");
        account.withdraw(300);
        assertEquals(700.0, account.getBalance());
    }

    @Test
    void testInsufficientFunds() {
        System.out.println("Act: withdraw 5000 and expect Insufficient funds exception");
        assertThrows(IllegalStateException.class, () -> account.withdraw(5000));
    }

    @Test
    void testNegativeDeposit() {
        System.out.println("Act: deposit -100 and expect IllegalArgumentException");
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    void testInitialBalance() {
        System.out.println("Assert: initial balance should be 1000.0");
        assertEquals(1000.0, account.getBalance());
    }
}
