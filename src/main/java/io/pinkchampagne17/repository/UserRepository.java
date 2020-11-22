package io.pinkchampagne17.repository;

import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.parameter.CreateUserParams;
import io.pinkchampagne17.parameter.UpdateUserParams;

public interface UserRepository {
    int createUser(CreateUserParams params);
    User getUserById(String id);
    User getUserByIdAndPassword(String id, String password);
    int updateUser(UpdateUserParams params);
}
