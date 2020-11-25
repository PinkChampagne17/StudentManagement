package io.pinkchampagne17.service;

import io.pinkchampagne17.entity.Class;
import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.parameter.CreateClassParams;

import java.util.List;

public interface ClassService {
    /**
     * 创建班级
     * @param params CreateClassParams
     * @return 创建成功后的班级
     */
    Class createClass(CreateClassParams params);

    /**
     * 使用班级id获取班级
     * @param id id
     * @return 符合条件的班级
     */
    Class getClassById(Long id);

    /**
     * 通过id获取班级成员
     * @param id 班级id
     * @return 班级成员
     */
    List<User> getMemberById(Long id);

    /**
     * 为班级添加新成员
     * @param classId 班级id
     * @param userId 用户id
     */
    void addMember(Long classId, String userId);

    /**
     * 移除班级成员
     * @param userId 用户id
     */
    void removeMember(String userId);
}
