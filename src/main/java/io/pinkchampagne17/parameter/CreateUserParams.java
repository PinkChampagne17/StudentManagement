package io.pinkchampagne17.parameter;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserParams {
    @NotNull
    @Size(min = 5, max = 20, message = "id需在5-20个字符之间")
    private String id;

    @NotNull
    @Size(min = 6, max = 20, message = "密码(password)需在6-20个字符之间")
    private String password;

    @NotNull(message = "是否为教师(isTeacher)不能为空")
    private Boolean isTeacher;
}
