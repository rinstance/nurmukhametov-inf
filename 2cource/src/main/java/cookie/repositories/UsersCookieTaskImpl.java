package cookie.repositories;


import cookie.models.UserWithCookie;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UsersCookieTaskImpl implements UsersCookieTaskRepository {
    private Connection connection;
    private SimpleJdbcTemplate jdbcTemplate;
    //language=SQL
    private static final String SQL_FIND_USER_BY_LOGIN = "select * from first_users where login like ?";
    //language=SQL
    private static final String SQL_FIND_USER_BY_UUID = "select * from first_users where uuid like ?";


    public UsersCookieTaskImpl(Connection connection) {
        this.connection = connection;
        this.jdbcTemplate = new SimpleJdbcTemplate(connection);
    }

    private RowMapper<UserWithCookie> usersRowMapper = row -> {
        return new UserWithCookie(
                row.getString("login"),
                row.getString("password"),
                row.getString("uuid")
                );
    };

    @Override
    public List<UserWithCookie> findByLogin(String login) {
        return jdbcTemplate.queryForList(SQL_FIND_USER_BY_LOGIN, usersRowMapper, login);
    }

    @Override
    public List<UserWithCookie> findByUUID(String uuid) {
        return jdbcTemplate.queryForList(SQL_FIND_USER_BY_UUID, usersRowMapper, uuid);
    }


    @Override
    public Optional<UserWithCookie> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<UserWithCookie> findAll() {
        return null;
    }

    @Override
    public void save(UserWithCookie entity) {

    }

    @Override
    public void update(UserWithCookie entity) {

    }

    @Override
    public void delete(UserWithCookie entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
