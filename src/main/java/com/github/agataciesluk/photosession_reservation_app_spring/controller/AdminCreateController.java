package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.service.UserBasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/create")
public class AdminCreateController {

    private static final String ROLE_ADMIN = "ADMIN";
    private final UserBasicService userBasicService;

    @GetMapping
    public String createAdmin() {
        if (userBasicService.findUserByRole(ROLE_ADMIN) == null) {
            log.info("No ADMIN found. Default admin can be created.");
            userBasicService.createDefaultAdmin();
            log.info("Default ADMIN created.");
        }
        return "redirect:http://localhost:8080/login";
    }
}
