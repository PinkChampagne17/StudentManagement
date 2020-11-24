package io.pinkchampagne17.parameter;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CreateClassParams {

    @Null
    private Long id;

    @Null
    private String creatorUserId;

    @Null
    private String inviteCode;

    @NotBlank(message = "班级名(name)不能为空")
    @Size(min = 2, max = 20, message = "班级名(name)需在2-20个字符之间")
    private String name;

    @NotBlank(message = "班级名(name)不能为空")
    @Size(min = 3, max = 20, message = "学校名(school)需在3-20个字符之间")
    private String school;

    @NotBlank(message = "班级名(name)不能为空")
    @Size(min = 3, max = 20, message = "院系名(department)需在3-20个字符之间")
    private String department;

    @NotBlank(message = "班级名(name)不能为空")
    @Size(min = 2, max = 20, message = "专业名(major)需在2-20个字符之间")
    private String major;

    @Min(value = 2014, message = "年级(year)年级不符合实际情况")
    private Integer year;

}
