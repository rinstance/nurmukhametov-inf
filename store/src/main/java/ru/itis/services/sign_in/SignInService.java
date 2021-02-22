package ru.itis.services.sign_in;

import ru.itis.models.dto.UserDto;
import ru.itis.models.dto.UserForm;

public interface SignInService {
    UserDto signIn(UserForm userForm);
    void incCount(Integer id);
}
