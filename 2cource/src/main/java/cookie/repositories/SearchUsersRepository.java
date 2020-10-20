package cookie.repositories;


import homeworks.model.User;

import java.util.List;

public interface SearchUsersRepository extends CrudRepository<User> {
    List<User> findAllByLoginStartingWith(String name);
}

