package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.service.ClientBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.UserBasicService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("Create client - form view controller specification ")
@WebMvcTest(value = ClientCreateFormController.class)
class ClientCreateFormControllerTest {

    @MockBean
    private ClientBasicService clientBasicService;

    @MockBean
    private UserBasicService userBasicService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should prepare a view for creating a Client")
    public void createClientForm_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/client/create"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/client/form-newClient"))
                .andExpect(MockMvcResultMatchers.model().attribute("client", clientBasicService.createEmptyClientToForm()))
                .andDo(MockMvcResultHandlers.print());
    }

}