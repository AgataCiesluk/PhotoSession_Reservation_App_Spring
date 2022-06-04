package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoSessionEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.service.PhotoSessionBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.UserBasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/photo-sess/all")
public class UserLoggedAllPhotoSessViewController {

    private final UserBasicService userBasicService;
    private static final String USER_LOGIN = "agataKlient";
    private final PhotoSessionBasicService photoSessionBasicService;

    @GetMapping
    public String showAllPhotoSess(Model model) {
        //Jak bedzie juz podpiety Spring Security to tutaj bedzie trzeba sprawdzic
        //czy zalogowany uzytkownik ma role ADMIN czy CLIENT i w zaleznosci od roli taki
        //model przekazac do widoku a w widoku juz zarzadzic w zaleznosci od roli uzytkownika
        //jaki widok na homepage bedzie mial ADMIN a jaki CLIENT.
        //Link jak to zrobic uzywajac spring security jest na Slacku w projekt-koncowy.
//        if ("ADMIN".equals(userBasicService.findUserByLogin("admin").getRole())) {
//            model.addAttribute("loggedUser", userBasicService.findUserByLogin("admin") );
//        }
        model.addAttribute("loggedUser", userBasicService.findUserByLogin(USER_LOGIN));
        return "/user/allPhotoSessView";
    }

    @ModelAttribute("allSessions")
    public List<PhotoSessionEntity> allSessions() {
        //tu przy uzyciu spring security odczytac role User'a i w zaleznosci od roli pobrac wszystkie przyszle sesje
        //ponizej kod dla danego zalogowanego uzytkownika
//        return photoSessionBasicService.getAllPhotoSessSorted();// --> metoda jesli uzytkownik ma role ADMIN
        return photoSessionBasicService.getAllSessByUserLoginSorted(USER_LOGIN); //--> metoda dla uztkownika innego niz ADMIN (klient) o znanym przez spring security loginie
    }
}