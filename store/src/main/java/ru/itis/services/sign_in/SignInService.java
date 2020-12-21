package services.sign_in;

import dto.UserDto;
import dto.UserForm;

public interface SignInService {
    UserDto signIn(UserForm userForm);
    void incCount(Integer id);
}
