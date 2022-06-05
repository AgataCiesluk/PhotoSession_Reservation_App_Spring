package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoSessionEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.service.CurrentUser;
import com.github.agataciesluk.photosession_reservation_app_spring.service.PhotoSessionBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.UserBasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/photo-sess/completed")
public class UserLoggedCompletedPhotoSessViewController {

    private final UserBasicService userBasicService;
    private final PhotoSessionBasicService photoSessionBasicService;

    @GetMapping
    public String showCompletedPhotoSess(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("loggedUser", userBasicService.findUserByUsername(currentUser.getUsername()));
        return "/user/completedPhotoSessView";
    }

    @ModelAttribute("completedSessions")
    public List<PhotoSessionEntity> completedSessions(@AuthenticationPrincipal CurrentUser currentUser) {
        if ("admin".equals(currentUser.getUsername())) {
            return photoSessionBasicService.getAllCompletedSessSorted();
        }
        return photoSessionBasicService.getAllCompletedSessByUsernameSorted(currentUser.getUsername());
    }
}
