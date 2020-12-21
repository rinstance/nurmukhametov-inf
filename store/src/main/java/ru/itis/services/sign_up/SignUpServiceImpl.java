package services.sign_up;

import dto.UserForm;
import models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.user.UserRepository;

public class SignUpServiceImpl implements SignUpService {
    private UserRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(UserForm form) {
        User user = new User(
                form.getFirstName(),
                form.getLastName(),
                form.getLogin(),
                passwordEncoder.encode(form.getPassword()));
        usersRepository.save(user);
    }
}
