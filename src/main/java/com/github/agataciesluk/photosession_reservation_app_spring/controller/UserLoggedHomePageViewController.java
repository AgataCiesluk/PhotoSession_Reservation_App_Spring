package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.service.AuthService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.ClientBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.UserBasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class UserLoggedHomePageViewController {

//    private static final String USER_LOGIN = "agataKlient";
    private final UserBasicService userBasicService;
    private final Authentication authentication;
    private final AuthService authService;

    @GetMapping
    public String homePageView(Model model) {
        UserDetails loggedUserDetails = authService.loadUserByUsername(authentication.getName());
        UserEntity logged
        model.addAttribute("loggedUser", loggedUser);
        return "/user/homePageView";
    }
}
