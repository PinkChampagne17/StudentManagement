package io.pinkchampagne17.service.impl;

import io.pinkchampagne17.entity.Class;
import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.parameter.CreateClassParams;
import io.pinkchampagne17.repository.ClassRepository;
import io.pinkchampagne17.service.ClassService;
import io.pinkchampagne17.service.SqlSessionService;
import net.bytebuddy.utility.RandomString;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private final SqlSessionService sqlSessionService;

    public ClassServiceImpl(SqlSessionService sqlSessionService) {
        this.sqlSessionService = sqlSessionService;
    }

    @Override
    public Class createClass(CreateClassParams params) {

        params.setInviteCode(RandomString.make(8));

        try (SqlSession sqlSession = sqlSessionService.openSession()) {

            ClassRepository classRepository = sqlSession.getMapper(ClassRepository.class);

            classRepository.createClass(params);
            sqlSession.commit();

            return classRepository.getClassById(params.getId());
        }
    }

    @Override
    public Class getClassById(Long id) {
        try (SqlSession sqlSession = sqlSessionService.openSession()) {
            ClassRepository classRepository = sqlSession.getMapper(ClassRepository.class);
            return classRepository.getClassById(id);
        }
    }

    @Override
    public List<User> getMemberById(Long id) {
        try (SqlSession sqlSession = sqlSessionService.openSession()) {
            ClassRepository classRepository = sqlSession.getMapper(ClassRepository.class);
            return classRepository.getMemberById(id);
        }
    }

    @Override
    public void addMember(Long classId, String userId) {
        try (SqlSession sqlSession = sqlSessionService.openSession()) {
            ClassRepository classRepository = sqlSession.getMapper(ClassRepository.class);
            classRepository.addMember(classId, userId);
            sqlSession.commit();
        }
    }

    @Override
    public void removeMember(String userId) {
        try (SqlSession sqlSession = sqlSessionService.openSession()) {
            ClassRepository classRepository = sqlSession.getMapper(ClassRepository.class);
            classRepository.removeMember(userId);
            sqlSession.commit();
        }
    }


}
