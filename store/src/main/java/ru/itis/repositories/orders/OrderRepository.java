package ru.itis.repositories.orders;

import ru.itis.models.entities.Order;
import ru.itis.repositories.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order> {
    List<Order> getOrdersByUserId(Integer id);
}
