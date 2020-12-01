package cookie.repositories;

import cookie.models.UserWithCookie;
import javax.servlet.http.Cookie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class AuthCookieTemplate {
    private Connection connection;
    private UsersCookieTaskRepository usersRepository;

    public AuthCookieTemplate(Connection connection) {
        this.connection = connection;
        usersRepository = new UsersCookieTaskImpl(connection);
    }

    public Cookie setCookieForUser(String log, String pas) throws SQLException {
        Cookie cookie = null;
        UserWithCookie user = usersRepository.findByLogin(log).get(0);
        if (user.getPassword().equals(pas)) {
            if (user.getUuid() == null) {
                String uuid = UUID.randomUUID().toString();
                user.setUuid(uuid);
                setUUID(user);
            }
            cookie = new Cookie("myCookie", user.getUuid());
        }
        return cookie;
    }

    private void setUUID(UserWithCookie user) throws SQLException {
        usersRepository.setUUID(user);
    }

}
