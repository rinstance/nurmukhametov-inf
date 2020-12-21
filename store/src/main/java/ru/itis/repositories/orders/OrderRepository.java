package repositories.orders;

import models.Order;
import repositories.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order> {
    List<Order> getOrdersByUserId(Integer id);
}
