package io.pinkchampagne17.service.impl;

import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.parameter.CreateUserParams;
import io.pinkchampagne17.parameter.UpdateUserParams;
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
    public User createUser(CreateUserParams params) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {

            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);

            userRepository.createUser(params);
            sqlSession.commit();

            return userRepository.getUserById(params.getId());
        }
    }

    @Override
    public User getUserById(String id) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            return userRepository.getUserById(id);
        }
    }

    @Override
    public User getUserByIdAndPassword(String id, String password) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            return userRepository.getUserByIdAndPassword(id, password);
        }
    }

    @Override
    public User updateUser(UpdateUserParams params) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            userRepository.updateUser(params);
            sqlSession.commit();
            return userRepository.getUserById(params.getId());
        }
    }

}
