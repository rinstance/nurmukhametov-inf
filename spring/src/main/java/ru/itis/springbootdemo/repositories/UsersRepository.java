package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.UserDetailsImpl;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByConfirmCode(String confirmCode);
    Optional<User> findByEmail(String email);
    Optional<User> getUserByEmailAndPassword(String email, String password);
}
