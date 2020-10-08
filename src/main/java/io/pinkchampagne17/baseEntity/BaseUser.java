package io.pinkchampagne17.baseEntity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class BaseUser {
    @Null
    private Long id;

    @NotNull
    private String name;
}
