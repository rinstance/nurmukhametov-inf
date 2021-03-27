package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
public class UserForm {
    private String email;
    private String password;
    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
