package io.pinkchampagne17.service;

import io.pinkchampagne17.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(String id);
    User getUserByIdAndPassword(String id, String password);
}
