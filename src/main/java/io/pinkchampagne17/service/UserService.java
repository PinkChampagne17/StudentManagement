package io.pinkchampagne17.service;

import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.parameter.CreateUserParams;
import io.pinkchampagne17.parameter.UpdateUserParams;

public interface UserService {
    User createUser(CreateUserParams params);
    User getUserById(String id);
    User getUserByIdAndPassword(String id, String password);
    User updateUser(UpdateUserParams params);
}
