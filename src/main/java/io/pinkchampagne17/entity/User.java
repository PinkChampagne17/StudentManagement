package io.pinkchampagne17.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private Boolean isTeacher;
    private String avatar;
    private String name;
    private Integer gender;
    private String phone;
    private String email;
    private String studentId;
    private String dormitory;
    private String className;
    private String school;
    private String department;
    private String major;
    private Integer year;
}
