package io.pinkchampagne17.service;

import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.parameter.CreateUserParams;
import io.pinkchampagne17.parameter.UpdateUserParams;

public interface UserService {
    /**
     * 创建用户
     * @param params CreateUserParams
     * @return 已创建成功的user对象
     */
    User createUser(CreateUserParams params);

    /**
     * 通过id获取user
     * @param id id
     * @return 符合条件的user
     */
    User getUserById(String id);

    /**
     * 通过id与密码获取user
     * @param id id
     * @param password 密码
     * @return 符合条件的user
     */
    User getUserByIdAndPassword(String id, String password);


    /**
     * 更新用户资料
     * @param params UpdateUserParams
     * @return 更新后的user对象
     */
    User updateUser(UpdateUserParams params);
}
