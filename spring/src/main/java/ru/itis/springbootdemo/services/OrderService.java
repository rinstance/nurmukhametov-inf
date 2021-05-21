package ru.itis.springbootdemo.services;

import ru.itis.springbootdemo.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllByUserId(Long userId);
    void addOrder(Long userId, Long itemId);
    List<Order> getByUserIdAndItemId(Long userId, Long itemId);
}
