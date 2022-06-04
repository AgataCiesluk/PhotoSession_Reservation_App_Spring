package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class UserLoginPageViewController {

    @GetMapping
    public String showLoginForm() {
        return "/user/form-userLogin";
    }
}
