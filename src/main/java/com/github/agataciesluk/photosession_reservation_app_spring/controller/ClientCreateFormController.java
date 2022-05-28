package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
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
        model.addAttribute("client", clientBasicService.createEmptyClient());
        return "/client/formView-newClient";
    }

    //Po uzupelnieniu formularza w metodzie POST stworzy sie nowy klient i user jednoczesnie
    //A nowy uzytkownik/klient zostanie odeslany do strony logowania dzieki czemu uzyskam
    //informacje jaki User (o jakiej roli i loginie) jest zalogowany (info o loginie potrzebne do Spring Security)
    @PostMapping
    public String handleNewClientForm(@ModelAttribute("client") @Valid ClientCreateForm client, BindingResult result) {
        if (result.hasErrors()) {
            return "/client/formView-newClient";
        }
        clientBasicService.saveClient(client);
        log.info("Client has been saved with first name: {} and with User login: {} and role: {}.", client.getFirstName(), client.getUserLogin(), client.getUserRole());
        return "/client/temporaryLoginPage";
    }
}
