package io.pinkchampagne17.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User{

    private String id;

    @JsonIgnore
    private String password;
}
