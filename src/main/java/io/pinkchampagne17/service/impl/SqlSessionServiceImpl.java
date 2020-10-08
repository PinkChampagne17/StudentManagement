package io.pinkchampagne17.service.impl;

import io.pinkchampagne17.Application;
import io.pinkchampagne17.service.SqlSessionService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class SqlSessionServiceImpl implements SqlSessionService {

    private final SqlSessionFactory sqlSessionFactory;

    public SqlSessionServiceImpl() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Override
    public SqlSession openSession() {
        return this.sqlSessionFactory.openSession();
    }
}
