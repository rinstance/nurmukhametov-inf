package ru.itis.springbootdemo.services;

import ru.itis.springbootdemo.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllByUserId(Long userId);
}
