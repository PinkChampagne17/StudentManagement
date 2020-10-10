package io.pinkchampagne17.service;

import io.pinkchampagne17.entity.User;

public interface UserService {
    User addUser(User user);
    User getUserById(Long id);
    User getUserByName(String name);
//    User updateUserName(Long id, String name);
//    User updatePassword(Long id, String password);
// end;
}
