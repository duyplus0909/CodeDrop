package com.codedrop.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.codedrop.model.User}
 */
@Value
public class UserDto implements Serializable {

    Integer id;

    @NotNull
    @Size(max = 100)
    String userCode;

    @NotNull
    @Size(max = 255)
    String email;

    @NotNull
    @Size(max = 100)
    String username;

    @NotNull
    @Size(max = 255)
    String password;

    @Size(max = 255)
    String fullname;

    @Size(max = 20)
    String phone;

    String photo;

    String token;

    Date createdAt;

    Date updatedAt;

    Boolean isDelete;
}