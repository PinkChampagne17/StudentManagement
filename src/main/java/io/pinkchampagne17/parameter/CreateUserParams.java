package io.pinkchampagne17.parameter;

import io.pinkchampagne17.entity.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserParams {
    @NotNull
    @Size(min = 5, max = 20)
    private String id;

    @NotNull
    @Size(min = 6, max = 20)
    private String password;

    @NotNull
    private Boolean isTeacher;

    public User toUser() {
        return new User() {
            {
                setId(id);
                setPassword(password);
                setIsTeacher(isTeacher);
            }
        };
    }
}
