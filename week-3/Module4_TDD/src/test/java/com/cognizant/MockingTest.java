package com.cognizant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MockingTest {
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    void testGetUserById_Mocking() {
        System.out.println("Running testGetUserById_Mocking");
        User user = new User(1, "Rahul", "rahul@email.com");
        when(userRepository.findById(1)).thenReturn(user);

        User foundUser = userService.getUserById(1);
        assertNotNull(foundUser);
        assertEquals("Rahul", foundUser.getName());
        assertEquals("rahul@email.com", foundUser.getEmail());
    }

    @Test
    void testGetUserName_WhenUserExists() {
        System.out.println("Running testGetUserName_WhenUserExists");
        when(userRepository.findById(1)).thenReturn(new User(1, "Priya", "priya@email.com"));

        assertEquals("Priya", userService.getUserName(1));
    }

    @Test
    void testGetUserName_WhenUserNotFound() {
        System.out.println("Running testGetUserName_WhenUserNotFound");
        when(userRepository.findById(99)).thenReturn(null);

        assertEquals("User not found", userService.getUserName(99));
    }

    @Test
    void testCreateUser_Stubbing() {
        System.out.println("Running testCreateUser_Stubbing");
        User newUser = new User(2, "Ananya", "ananya@email.com");
        when(userRepository.save(newUser)).thenReturn(true);

        assertTrue(userService.createUser(newUser));
    }

    @Test
    void testThrowException_Stubbing() {
        System.out.println("Running testThrowException_Stubbing");
        when(userRepository.findById(-1)).thenThrow(new IllegalArgumentException("Invalid ID!"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.getUserById(-1));
        assertEquals("Invalid ID!", exception.getMessage());
    }
}
