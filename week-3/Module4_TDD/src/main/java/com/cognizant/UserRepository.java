package com.cognizant;

public interface UserRepository {
    User findById(int id);
    boolean save(User user);
    void delete(int id);
}
