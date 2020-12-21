package services.orders;

import models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    void save(Order order);
    List<Order> getOrdersByUserId(Integer id);
}
