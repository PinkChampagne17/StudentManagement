package io.pinkchampagne17.repository;

import io.pinkchampagne17.entity.Class;
import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.parameter.CreateClassParams;

import java.util.List;

public interface ClassRepository {
    int createClass(CreateClassParams params);
    Class getClassById(Long id);
    List<User> getMemberById(Long id);
    int addMember(Long classId, String userId);
    int removeMember(String userId);
}
