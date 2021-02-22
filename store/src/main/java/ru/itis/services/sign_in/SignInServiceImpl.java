package ru.itis.services.sign_in;

import ru.itis.models.dto.UserDto;
import ru.itis.models.dto.UserForm;
import ru.itis.models.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.repositories.user.UserRepository;

import java.util.Optional;

public class SignInServiceImpl implements SignInService {
    private UserRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public SignInServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto signIn(UserForm userForm) {
        Optional<User> userOptional = usersRepository.findByLogin(userForm.getLogin());
        usersRepository.findByLogin(userForm.getLogin());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(userForm.getPassword(), user.getHashPassword())) {
                return UserDto.from(user);
            } else return null;
        }
        return null;
    }

    @Override
    public void incCount(Integer id) {
        usersRepository.incCount(id);
    }
}
