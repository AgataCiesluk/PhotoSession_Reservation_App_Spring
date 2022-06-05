package com.github.agataciesluk.photosession_reservation_app_spring.service;


import com.github.agataciesluk.photosession_reservation_app_spring.controller.ClientCreateForm;
import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;

import java.util.List;

public interface ClientService {

    ClientCreateForm createEmptyClientToForm();
    void saveClient(ClientCreateForm clientCreateForm);
    ClientEntity getClientByUsername(String username);
    ClientEntity getClientByEmail(String email);
    ClientEntity getClientByPhoneNumber(String phoneNumber);
    List<ClientEntity> getAllClients();
}
