package cookie.repositories;

import cookie.models.UserWithCookie;

import java.util.List;

public interface UsersCookieRepository extends CrudRepository<UserWithCookie> {
    List<UserWithCookie> findByLogin(String login);
    List<UserWithCookie> findByUUID(String uuid);
}
