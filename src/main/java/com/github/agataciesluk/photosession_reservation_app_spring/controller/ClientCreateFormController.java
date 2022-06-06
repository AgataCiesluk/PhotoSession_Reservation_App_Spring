package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.service.ClientBasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/client/create")
public class ClientCreateFormController {

    private final ClientBasicService clientBasicService;

    @GetMapping
    public String createClientForm(Model model) {
        model.addAttribute("client", clientBasicService.createEmptyClientToForm());
        return "/client/form-newClient";
    }

    @PostMapping
    public String handleNewClientForm(@ModelAttribute("client") @Valid ClientCreateForm client, BindingResult result) {
        if (result.hasErrors()) {
            return "/client/form-newClient";
        }
        clientBasicService.saveClient(client);
        log.info("Client has been saved with first name: {} and with User username: {} and role: {}.", client.getFirstName(), client.getUsername(), client.getUserRole());
        return "redirect:http://localhost:8080/login";
    }
}
