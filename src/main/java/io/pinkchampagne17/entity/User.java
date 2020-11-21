package io.pinkchampagne17.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {

    private String id;

    @JsonIgnore
    private String password;

    private Boolean isTeacher;
    private String avatar;
    private String name;
    private Integer gender;
    private String phone;
    private String email;
    private String studentId;
    private String dormitory;
}
