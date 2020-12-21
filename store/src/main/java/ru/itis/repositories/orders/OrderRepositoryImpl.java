package repositories.orders;

import models.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from orders";
    //language=SQL
    private static final String SQL_INSERT =
            "insert into orders(user_id, tx_id, order_time, get_date, item_name) values (?, ?, ?, ?, ?);";
    //language=SQL
    private static final String SQL_SELECT_BY_USER_ID =
            "select * from orders where user_id = ?;";

    private JdbcTemplate jdbcTemplate;

    public OrderRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Order> orderRowMapper = (row, rowNumber) -> {
        Order order = new Order();
        order.setGetDate(row.getDate("get_date"));
        order.setId(row.getInt("id"));
        order.setUser_id(row.getInt("user_id"));
        order.setTx_id(row.getInt("tx_id"));
        order.setOrder_time(row.getTimestamp("order_time"));
        order.setItemName(row.getString("item_name"));
        return order;
    };

    @Override
    public void save(Order entity) {
        jdbcTemplate.update(SQL_INSERT,
                entity.getUser_id(),
                entity.getTx_id(),
                entity.getOrder_time(),
                entity.getGetDate(),
                entity.getItemName());
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Order> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, orderRowMapper);
    }

    @Override
    public List<Order> getOrdersByUserId(Integer id) {
        return jdbcTemplate.query(SQL_SELECT_BY_USER_ID, orderRowMapper, id);
    }
}
