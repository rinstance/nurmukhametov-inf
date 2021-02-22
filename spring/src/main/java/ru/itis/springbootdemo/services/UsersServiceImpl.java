package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.List;
import static ru.itis.springbootdemo.dto.UserDto.*;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public boolean getUUID(String confirmCode) {
        User user = usersRepository.findByConfirmCode(confirmCode).orElse(new User());
        if (user.getConfirmCode() == null || user.getConfirmCode().equals(""))
            return false;
        else {
            user.setState(State.CONFIRMED);
            usersRepository.save(user);
            return true;
        }
    }
}
