package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.UserForm;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.services.SignUpService;

@Controller
public class SignInController {
    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "sign_in_page";
    }
}
