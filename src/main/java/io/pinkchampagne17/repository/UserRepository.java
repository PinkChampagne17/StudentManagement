package io.pinkchampagne17.repository;

import io.pinkchampagne17.entity.User;

public interface UserRepository {
    int createUser(User user);
    User getUserById(String id);
    User getUserByIdAndPassword(String id, String password);
}
