package io.pinkchampagne17.entity;

import io.pinkchampagne17.baseEntity.BaseUser;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User extends BaseUser {
    @NotNull
    private String password;
}
