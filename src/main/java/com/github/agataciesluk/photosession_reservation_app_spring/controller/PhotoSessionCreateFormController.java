package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoTypeEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.service.ClientBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.PhotoSessionBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.PhotoTypeBasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client/session-add")
public class PhotoSessionCreateFormController {

    private final PhotoSessionBasicService photoSessionBasicService;
    private final ClientBasicService clientBasicService;
    private final PhotoTypeBasicService photoTypeBasicService;

    @GetMapping
    public String createPhotoSessionForm(@RequestParam String username, Model model) {
        PhotoSessionCreateForm photoSession = photoSessionBasicService.createEmptyPhotoSessionToForm();
        photoSession.setClient(clientBasicService.getClientByUsername(username));
        model.addAttribute("photoSession", photoSession);
        return "/client/form-newPhotoSession";
    }

    @PostMapping
    public String handleNewPhotoSessionForm(@ModelAttribute("photoSession") @Valid PhotoSessionCreateForm photoSession, BindingResult result) {
        if (result.hasErrors()) {
            return "/client/form-newPhotoSession";
        }
        photoSessionBasicService.savePhotoSession(photoSession);
        return "redirect:http://localhost:8080/homepage";
    }

    @ModelAttribute("types")
    public List<PhotoTypeEntity> types() {
        return photoTypeBasicService.getAllPhotoTypes();
    }
}
