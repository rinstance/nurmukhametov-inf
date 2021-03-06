package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.UserForm;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private MailsService mailsService;


    @Override
    public void signUp(UserForm form) {
        User newUser = new User();
        newUser.setEmail(form.getEmail());
        newUser.setPassword(form.getPassword());
        newUser.setState(State.NOT_CONFIRMED);
        newUser.setConfirmCode(UUID.randomUUID().toString());
        usersRepository.save(newUser);
        mailsService.sendEmailForConfirm(newUser.getEmail(), newUser.getConfirmCode());
    }
}
