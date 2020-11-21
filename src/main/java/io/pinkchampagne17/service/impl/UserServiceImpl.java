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

    /**
     * 创建用户
     * @param user user
     * @return 已创建成功的user对象
     */
    @Override
    public User createUser(User user) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {

            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);

            userRepository.createUser(user);
            sqlSession.commit();

            return userRepository.getUserById(user.getId());
        }
    }

    /**
     * 通过id获取user
     * @param id id
     * @return 符合条件的user
     */
    @Override
    public User getUserById(String id) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            return userRepository.getUserById(id);
        }
    }

    /**
     * 通过id与密码获取user
     * @param id id
     * @param password 密码
     * @return 符合条件的user
     */
    @Override
    public User getUserByIdAndPassword(String id, String password) {
        try (SqlSession sqlSession = this.sqlSessionService.openSession()) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            return userRepository.getUserByIdAndPassword(id, password);
        }
    }
}
