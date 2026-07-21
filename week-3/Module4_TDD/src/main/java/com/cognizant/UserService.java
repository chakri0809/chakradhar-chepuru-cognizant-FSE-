package com.cognizant;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repo) {
        this.userRepository = repo;
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public String getUserName(int id) {
        User user = userRepository.findById(id);
        return user != null ? user.getName() : "User not found";
    }

    public boolean createUser(User user) {
        return userRepository.save(user);
    }
}
