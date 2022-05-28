package com.github.agataciesluk.photosession_reservation_app_spring.service;


import com.github.agataciesluk.photosession_reservation_app_spring.controller.ClientCreateForm;

public interface ClientService {

    ClientCreateForm createEmptyClient();
    void saveClient(ClientCreateForm clientCreateForm);
}
