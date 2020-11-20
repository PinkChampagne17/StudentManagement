package io.pinkchampagne17.parameter;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateTokenParams {
    @NotNull
    @Size(min = 5, max = 20)
    private String id;

    @NotNull
    @Size(min = 6, max = 20)
    private String password;
}
