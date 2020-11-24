package io.pinkchampagne17.service;

import io.pinkchampagne17.entity.Class;
import io.pinkchampagne17.parameter.CreateClassParams;

public interface ClassService {
    /**
     * 创建班级
     * @param params CreateClassParams
     * @return 创建成功后的班级
     */
    Class createClass(CreateClassParams params);
    Class getClassById(Long id);
}
