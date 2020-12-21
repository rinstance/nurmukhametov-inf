package services.sign_in;

import dto.UserDto;
import dto.UserForm;
import models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.user.UserRepository;

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
