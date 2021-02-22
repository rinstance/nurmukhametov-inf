package ru.itis.services.sign_up;

import ru.itis.models.dto.UserForm;

public interface SignUpService {
    void signUp(UserForm form);
}
