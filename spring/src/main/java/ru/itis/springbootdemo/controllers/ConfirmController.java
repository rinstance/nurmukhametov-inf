package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springbootdemo.services.MailsService;
import ru.itis.springbootdemo.services.UsersService;

@Controller
public class ConfirmController {
    @Autowired
    private MailsService mailsService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String confirmCode) {
        if (usersService.getUUID(confirmCode))
            return "accept_mail";
        return null;
    }
}
