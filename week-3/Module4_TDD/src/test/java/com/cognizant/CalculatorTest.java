
package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        System.out.println("Running testAddition");
        assertEquals(8, calculator.add(5, 3));
    }

    @Test
    void testSubtraction() {
        System.out.println("Running testSubtraction");
        assertEquals(6, calculator.subtract(10, 4));
    }

    @Test
    void testMultiplication() {
        System.out.println("Running testMultiplication");
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void testDivision() {
        System.out.println("Running testDivision");
        assertEquals(5.0, calculator.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        System.out.println("Running testDivideByZero");
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
