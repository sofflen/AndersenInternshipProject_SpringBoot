package com.jiratask.crud.dto;

import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private String password;
    private String email;
    private int roleId;
}
