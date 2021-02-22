package ru.itis.repositories.tx;

import ru.itis.models.entities.Transaction;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class TxRepositoryImpl implements TxRepository {
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from tx";
    //language=SQL
    private static final String SQL_FIND_BY_ID = "select * from tx where id = ?";
    //language=SQL
    private static final String SQL_INSERT = "insert into tx(type) values (?);";
    //language=SQL
    private static final String SQL_GET_LAST =
            "SELECT * FROM tx WHERE id=(SELECT MAX(id) FROM tx);";

    private JdbcTemplate jdbcTemplate;

    public TxRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Transaction> transactionRowMapper = (row, rowNumber) -> {
        Transaction transaction = new Transaction();
        transaction.setId(row.getInt("id"));
        transaction.setType(row.getString("type"));
        return transaction;
    };
    @Override
    public void save(Transaction entity) {
        jdbcTemplate.update(SQL_INSERT, entity.getType());
    }

    @Override
    public void update(Transaction entity) {
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Transaction> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, transactionRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public Transaction getLast() {
        return jdbcTemplate.query(SQL_GET_LAST, transactionRowMapper).get(0);
    }
}
