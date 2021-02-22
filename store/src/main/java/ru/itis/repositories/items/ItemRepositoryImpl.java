package ru.itis.repositories.items;

import ru.itis.models.entities.Item;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ItemRepositoryImpl implements ItemRepository {
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from items";
    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from items where id = ?";
    //language=SQL
    private static final String SQL_DELETE_BY_ID = "select * from items where id = ?";
    //language=SQL
    private static final String SQL_DEC_COUNT =
            "UPDATE items SET count = count-1 where id = ?;";
    //language=SQL
    private static final String SQL_INSERT =
            "insert into items(name, count, img, company_id) values (?, ?, ?, ?);";

    private JdbcTemplate jdbcTemplate;

    public ItemRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Item> itemRowMapper = (row, rowNumber) -> {
        Item item = new Item();
        item.setCompany_id(row.getInt("company_id"));
        item.setCount(row.getInt("count"));
        item.setImg(row.getString("img"));
        item.setName(row.getString("name"));
        item.setId(row.getInt("id"));
        return item;
    };

    @Override
    public void save(Item entity) {
        jdbcTemplate.update(SQL_INSERT,
                entity.getName(),
                entity.getCount(),
                entity.getImg(),
                entity.getCompany_id());
    }

    @Override
    public void update(Item entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Item> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, itemRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Item> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, itemRowMapper);
    }

    @Override
    public void decCount(Integer id) {
        jdbcTemplate.update(SQL_DEC_COUNT, id);
    }
}
