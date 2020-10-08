package io.pinkchampagne17.repository;

import io.pinkchampagne17.entity.User;

public interface UserRepository {
    int addUser(User user);
    User getUserById(Long id);
    User getUserByName(String name);
//    User updateUserName(Long id, String name);
//    User updatePassword(Long id, String password);
}
