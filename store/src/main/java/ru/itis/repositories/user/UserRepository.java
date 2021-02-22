package ru.itis.repositories.user;

import ru.itis.models.entities.User;
import ru.itis.repositories.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    Optional<User> findByLogin(String login);
    void incCount(Integer id);
}
