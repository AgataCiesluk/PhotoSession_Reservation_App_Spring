package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.service.ClientBasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/all-clients")
public class AdminAllClientsViewController {

    private final ClientBasicService clientBasicService;

    @GetMapping
    public String showAllClients(Model model) {
        model.addAttribute("clients", clientBasicService.getAllClients());
        return "/admin/allClientsView";
    }
}
