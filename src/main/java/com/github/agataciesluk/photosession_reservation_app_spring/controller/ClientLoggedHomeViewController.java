package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.service.ClientBasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/client/homepage")
public class ClientLoggedHomeViewController {

    private static final String USER_LOGIN = "agataKlient";
    private final ClientBasicService clientBasicService;

    @GetMapping
    public String homePageView(Model model) {
        model.addAttribute("loggedClient", clientBasicService.getClientByUserLogin(USER_LOGIN));
        return "/client/clientHomePageView";
    }


}
