package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.service.CurrentUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class UserLoggedHomePageViewController {

    @GetMapping
    public String homePageView(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("loggedUser", currentUser.getUserEntity());
        return "/user/homePageView";
    }
}
