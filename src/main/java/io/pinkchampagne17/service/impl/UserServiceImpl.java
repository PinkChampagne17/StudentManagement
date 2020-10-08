package io.pinkchampagne17.service.impl;

import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.repository.UserRepository;
import io.pinkchampagne17.service.SqlSessionService;
import io.pinkchampagne17.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final SqlSessionService sqlSessionService;

    public UserServiceImpl(SqlSessionService sqlSessionService) {
        this.sqlSessionService = sqlSessionService;
    }

    @Override
    public User addUser(User user) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {

            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);

            userRepository.addUser(user);
            sqlSession.commit();

            User newUser = userRepository.getUserByName(user.getName());
            return newUser;

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public User getUserById(Long id) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {

            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            User user = userRepository.getUserById(id);
            return user;
        }
    }

    @Override
    public User getUserByName(String name) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            User user = userRepository.getUserByName(name);
            return user;
        }
    }
}
