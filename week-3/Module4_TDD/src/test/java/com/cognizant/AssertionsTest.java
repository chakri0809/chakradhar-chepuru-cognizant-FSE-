package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testAssertEquals() {
        System.out.println("Running testAssertEquals");
        assertEquals(10, 5 + 5);
        assertEquals("Hello", "Hello");
    }

    @Test
    void testAssertTrue_AssertFalse() {
        System.out.println("Running testAssertTrue_AssertFalse");
        assertTrue(3 > 1);
        assertFalse(2 > 5);
    }

    @Test
    void testAssertNull_AssertNotNull() {
        System.out.println("Running testAssertNull_AssertNotNull");
        String value = null;
        assertNull(value);
        assertNotNull("Java");
    }

    @Test
    void testAssertArrayEquals() {
        System.out.println("Running testAssertArrayEquals");
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAssertThrows() {
        System.out.println("Running testAssertThrows");
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            throw new ArithmeticException("/ by zero");
        });
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void testAssertAll() {
        System.out.println("Running testAssertAll");
        assertAll(
                () -> assertEquals(4, 2 + 2),
                () -> assertTrue(7 > 3),
                () -> assertFalse(1 > 2),
                () -> assertEquals("Cognizant", "Cognizant")
        );
    }

    @Test
    void testAssertWithMessage() {
        System.out.println("Running testAssertWithMessage");
        assertEquals(100, 50 + 50, "The sum should be 100");
    }
}
