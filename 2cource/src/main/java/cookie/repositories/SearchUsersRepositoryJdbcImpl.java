package cookie.repositories;

import homeworks.model.User;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class SearchUsersRepositoryJdbcImpl implements SearchUsersRepository {
    //language=SQL
    private static final String FIND_ALL_USERS_BY_LOGIN = "select * from first_users where login like ?";
    private Connection connection;
    private SimpleJdbcTemplate jdbcTemplate;

    public SearchUsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        this.jdbcTemplate = new SimpleJdbcTemplate(connection);
    }

    private final RowMapper<User> usersRowMapper = row -> {
        return new User(
                row.getString("login"),
                row.getString("password")
        );
    };


    @Override
    public List<User> findAllByLoginStartingWith(String name) {
        System.out.println("HERE");
        return jdbcTemplate.queryForList(FIND_ALL_USERS_BY_LOGIN, usersRowMapper, name + "%");
    }


    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
