package io.pinkchampagne17.repository.Impl;

import io.pinkchampagne17.repository.UserRepository;
import io.pinkchampagne17.entity.User;

import java.util.HashMap;
import java.util.Map;

//public class UserRepositoryMemImpl implements UserRepository {
//
//    private Map<Long, User> map = new HashMap<Long, User>();
//    private Long nextId = 0L;
//
//    @Override
//    public User addUser(User user) {
//        user.setId(this.nextId);
//        this.nextId++;
//
//        map.put(user.getId(), user);
//        return user;
//    }
//
//    @Override
//    public User getUserById(Long id) {
//        return map.get(id);
//    }
//
//    @Override
//    public User updateUserName(Long id, String name) {
//        var user = getUserById(id);
//        user.setName(name);
//        return user;
//    }
//
//    @Override
//    public User updatePassword(Long id, String password) {
//        var user = getUserById(id);
//        user.setPassword(password);
//        return user;
//    }
//}
