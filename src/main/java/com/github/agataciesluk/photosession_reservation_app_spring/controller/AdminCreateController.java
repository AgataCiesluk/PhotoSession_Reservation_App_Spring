package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.service.UserBasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/create")
public class AdminCreateController {

    private final UserBasicService userBasicService;

    @GetMapping
    public String createAdmin() {
        UserEntity admin = new UserEntity();
        admin.setUsername("admin");
        admin.setRole("ADMIN");
        admin.setPassword("admin1234");
        userBasicService.saveUser(admin);
        return "redirect:http://localhost:8080/login";
    }
}
