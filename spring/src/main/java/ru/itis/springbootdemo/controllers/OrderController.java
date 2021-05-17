package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootdemo.models.Order;
import ru.itis.springbootdemo.repositories.OrderRepository;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.services.OrderService;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String getUserOrders(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("orders", orderService.getAllByUserId(userDetails.getUser().getId()));
        return "orders";
    }
}
