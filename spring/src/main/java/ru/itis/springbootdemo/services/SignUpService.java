package ru.itis.springbootdemo.services;

import ru.itis.springbootdemo.dto.UserForm;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.UserDetailsImpl;

public interface SignUpService {
    void signUp(UserForm form);
    UserDetailsImpl getUser(UserForm userForm);
}
