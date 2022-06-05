package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.service.PhotoSessionBasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/sess-complete")
public class AdminCompletePhotoSessController {

    private final PhotoSessionBasicService photoSessionBasicService;

    @GetMapping
    public String completePhotoSess(@RequestParam("id") long id) {
        photoSessionBasicService.savePhotoSessionCompleted(photoSessionBasicService.getPhotoSessById(id));
        return "redirect:http://localhost:8080/photo-sess/all";
    }
}
