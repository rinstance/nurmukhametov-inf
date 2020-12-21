package ru.itis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    //sign up
    public UserForm(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    //sign in
    public UserForm(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
