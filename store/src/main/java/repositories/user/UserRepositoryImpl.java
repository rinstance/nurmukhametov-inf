package repositories.user;

import models.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    //language=SQL
    private static final String SQL_INSERT =
            "insert into users(login, hash_password, first_name, last_name, count_purchased_items) " +
                    "values (?, ?, ?, ?, ?);";
    //language=SQL
    private static final String SQL_SELECT_BY_LOGIN = "select * from users where login = ?";
    //language=SQL
    private static final String SQL_INC_COUNT =
            "UPDATE users SET count_purchased_items = count_purchased_items+1 where id = ?;";

    private JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = (row, rowNumber) -> {
        User user = new User();
        user.setId(row.getInt("id"));
        user.setFirstName(row.getString("first_name"));
        user.setLastName(row.getString("last_name"));
        user.setLogin(row.getString("login"));
        user.setHashPassword(row.getString("hash_password"));
        user.setCountPurchasedItems(row.getInt("count_purchased_items"));
        return user;
    };

    @Override
    public Optional<User> findByLogin(String login) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_LOGIN, userRowMapper, login));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void incCount(Integer id) {
        jdbcTemplate.update(SQL_INC_COUNT, id);
    }

    @Override
    public void save(User entity) {
            jdbcTemplate.update(SQL_INSERT,
                entity.getLogin(),
                entity.getHashPassword(),
                entity.getFirstName(),
                entity.getLastName(),
                0);
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
