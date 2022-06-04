package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/logout")
public class UserLogoutViewController {

    @GetMapping
    public String logoutAction() {
        return "/user/form-userLogout";
    }
}
