package cookie.repositories;


import cookie.models.UserWithCookie;

import java.util.List;

public interface UsersCookieTaskRepository extends CrudRepository<UserWithCookie> {
    List<UserWithCookie> findByLogin(String login);
    List<UserWithCookie> findByUUID(String uuid);
    void setUUID(UserWithCookie user);
}
