package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.service.ClientBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.PhotoSessionBasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client/session-add")
public class PhotoSessionCreateFormController {

    private final PhotoSessionBasicService photoSessionBasicService;
    private final ClientBasicService clientBasicService;

    @GetMapping
    public String createPhotoSessionForm(@RequestParam String userLogin, Model model) {
        PhotoSessionCreateForm photoSession = photoSessionBasicService.createEmptyPhotoSessionToForm();
        photoSession.setClient(clientBasicService.getClientByUserLogin(userLogin));
        model.addAttribute("photoSession", photoSession);
        return "/client/formView-newPhotoSession";
    }

    @PostMapping
    public String handleNewPhotoSessionForm(@ModelAttribute("photoSession") @Valid PhotoSessionCreateForm photoSession, BindingResult result) {
        if (result.hasErrors()) {
            return "/client/formView-newPhotoSession";
        }
        photoSessionBasicService.savePhotoSession(photoSession);
        return "redirect:http://localhost:8080/client/views/homepage";
    }
}
