package io.pinkchampagne17.entity;

import lombok.Data;

@Data
public class Class {
    private Long id;
    private String name;
    private String school;
    private String department;
    private String major;
    private Integer year;
    private String creatorUserId;
    private String inviteCode;
}
