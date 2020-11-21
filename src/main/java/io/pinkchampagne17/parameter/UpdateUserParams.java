package io.pinkchampagne17.parameter;

import io.pinkchampagne17.entity.GenderEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserParams {
    @NotNull
    @Size(min = 5, max = 20)
    private String id;

    @Size(max = 15)
    private String name;

    @NotNull
    private GenderEnum gender;

    @Size(max = 11)
    private String phone;

    @Size(max = 30)
    private String email;

    @Size(max = 20)
    private String studentId;

    @Size(max = 20)
    private String dormitory;
}

