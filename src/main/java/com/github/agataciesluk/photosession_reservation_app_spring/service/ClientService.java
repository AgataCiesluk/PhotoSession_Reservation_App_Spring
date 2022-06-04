package com.github.agataciesluk.photosession_reservation_app_spring.service;


import com.github.agataciesluk.photosession_reservation_app_spring.controller.ClientCreateForm;
import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;

public interface ClientService {

    ClientCreateForm createEmptyClientToForm();
    void saveClient(ClientCreateForm clientCreateForm);
    ClientEntity getClientByUserLogin(String userLogin);
    ClientEntity getClientByEmail(String email);
    ClientEntity getClientByPhoneNumber(String phoneNumber);
}
