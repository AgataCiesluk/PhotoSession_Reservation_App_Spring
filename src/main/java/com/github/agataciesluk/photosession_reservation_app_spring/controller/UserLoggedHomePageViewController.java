package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.service.ClientBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.UserBasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class UserLoggedHomePageViewController {

    private static final String USER_LOGIN = "agataKlient";
    private final UserBasicService userBasicService;

    @GetMapping
    public String homePageView(Model model) {
        //Jak bedzie juz podpiety Spring Security to tutaj bedzie trzeba sprawdzic
        //czy zalogowany uzytkownik ma role ADMIN czy CLIENT i w zaleznosci od roli taki
        //model przekazac do widoku a w widoku juz zarzadzic w zaleznosci od roli uzytkownika
        //jaki widok na homepage bedzie mial ADMIN a jaki CLIENT.
        //Link jak to zrobic uzywajac spring security jest na Slacku w projekt-koncowy.
//        if ("ADMIN".equals(userBasicService.findUserByLogin("admin").getRole())) {
//            model.addAttribute("loggedUser", userBasicService.findUserByLogin("admin") );
//        }
        model.addAttribute("loggedUser", userBasicService.findUserByLogin(USER_LOGIN));
        return "/user/homePageView";
    }


}
