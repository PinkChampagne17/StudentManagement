package io.pinkchampagne17.entity;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private Long studentId;
    private String name;
    private Integer age;
    private GenderEnum gender;
}
