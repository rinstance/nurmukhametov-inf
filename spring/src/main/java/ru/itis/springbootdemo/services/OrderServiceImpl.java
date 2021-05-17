package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.models.Order;
import ru.itis.springbootdemo.repositories.ItemRepository;
import ru.itis.springbootdemo.repositories.OrderRepository;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }
}
