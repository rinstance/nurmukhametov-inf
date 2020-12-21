package repositories.user;

import models.User;
import repositories.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    Optional<User> findByLogin(String login);
    void incCount(Integer id);
}
