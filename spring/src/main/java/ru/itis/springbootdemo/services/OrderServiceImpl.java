package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.models.Order;
import ru.itis.springbootdemo.repositories.ItemRepository;
import ru.itis.springbootdemo.repositories.OrderRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public void addOrder(Long userId, Long itemId) {
        Calendar calendar = Calendar.getInstance();
        long orderTime = calendar.getTime().getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        orderRepository.save(new Order(
                userId,
                new Date(orderTime),
                new Date(calendar.getTime().getTime()),
                itemId
        ));
    }

    @Override
    public List<Order> getByUserIdAndItemId(Long userId, Long itemId) {
        List<Order> list = orderRepository.getByUserIdAndItemId(userId, itemId);
        list.sort((o1, o2) -> (int) (o1.getItemId() - o2.getItemId()));
        List<Order> order = new ArrayList<>();
        order.add(list.get(0));
        return order;
    }
}
