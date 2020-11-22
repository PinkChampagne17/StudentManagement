package io.pinkchampagne17.parameter;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateUserParams {
    private String id;

    @Size(min = 2, max = 15, message = "姓名(name)需在2-15个字之间")
    private String name;

    @NotNull(message = "性别(gender)不能为空")
    private Integer gender;

    @Size(max = 11, message = "电话号码(phone)位数最大11位")
    private String phone;

    @Size(max = 30, message = "电子邮件地址(email)最多可填30个字符")
    private String email;

    @Size(max = 20, message = "学号(studentId)最多可填20个字符")
    private String studentId;

    @Size(max = 20, message = "宿舍名(dormitory)最多可填20个字")
    private String dormitory;
}

