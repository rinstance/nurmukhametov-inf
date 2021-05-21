package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.springbootdemo.models.Item;
import ru.itis.springbootdemo.models.Order;
import ru.itis.springbootdemo.repositories.OrderRepository;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.services.ItemService;
import ru.itis.springbootdemo.services.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemService itemService;

    @GetMapping("/orders")
    public String getUserOrders(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Map<Order, Item> map = new HashMap<>();
        List<Order> orders = orderService.getAllByUserId(userDetails.getUser().getId());
        for (Order order : orders) {
            map.put(order, itemService.getById(order.getItemId()));
        }
        model.addAttribute("orders", map);
        return "orders";
    }

    @GetMapping("/order/saved")
    public String itemSave(@RequestParam("id") Long itemId, @AuthenticationPrincipal UserDetailsImpl userDetails,
                           Model model) {
        orderService.addOrder(userDetails.getUser().getId(), itemId);
        List<Order> order = orderService.getByUserIdAndItemId(userDetails.getUser().getId(), itemId);
        model.addAttribute("savedOrders", order);
        return "order_saved";
    }
}
