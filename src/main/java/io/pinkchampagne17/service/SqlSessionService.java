package io.pinkchampagne17.service;

import org.apache.ibatis.session.SqlSession;

public interface SqlSessionService {
    SqlSession openSession();
}
