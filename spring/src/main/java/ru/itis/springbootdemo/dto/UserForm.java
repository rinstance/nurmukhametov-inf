package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
public class UserForm {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
