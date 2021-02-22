package ru.itis.services.orders;

import ru.itis.models.entities.Order;
import ru.itis.repositories.orders.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Integer id) {
        return orderRepository.getOrdersByUserId(id);
    }
}
