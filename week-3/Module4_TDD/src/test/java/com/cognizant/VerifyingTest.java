package com.cognizant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class VerifyingTest {
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    void testVerify_MethodWasCalled() {
        System.out.println("testVerify_MethodWasCalled");
        when(userRepository.findById(1)).thenReturn(new User(1, "Rahul", "rahul@email.com"));

        userService.getUserById(1);
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    void testVerify_MethodCalledMultipleTimes() {
        System.out.println("testVerify_MethodCalledMultipleTimes");
        when(userRepository.findById(1)).thenReturn(new User(1, "Rahul", "rahul@email.com"));

        userService.getUserById(1);
        userService.getUserById(1);
        userService.getUserById(1);
        verify(userRepository, times(3)).findById(1);
    }

    @Test
    void testVerify_MethodNeverCalled() {
        System.out.println("testVerify_MethodNeverCalled");
        verify(userRepository, never()).findById(anyInt());
    }

    @Test
    void testVerify_AtLeastOnce() {
        System.out.println("testVerify_AtLeastOnce");
        when(userRepository.findById(1)).thenReturn(new User(1, "Rahul", "rahul@email.com"));

        userService.getUserById(1);
        userService.getUserById(1);
        verify(userRepository, atLeastOnce()).findById(1);
    }

    @Test
    void testVerify_WithArgumentMatchers() {
        System.out.println("testVerify_WithArgumentMatchers");
        when(userRepository.findById(anyInt())).thenReturn(new User(5, "Ravi", "ravi@email.com"));

        User result = userService.getUserById(5);
        verify(userRepository).findById(anyInt());
        assertEquals("Ravi", result.getName());
    }

    @Test
    void testVerifyNoMoreInteractions() {
        System.out.println("testVerifyNoMoreInteractions");
        when(userRepository.findById(1)).thenReturn(new User(1, "Rahul", "rahul@email.com"));

        userService.getUserById(1);
        verify(userRepository).findById(1);
        verifyNoMoreInteractions(userRepository);
    }
}
