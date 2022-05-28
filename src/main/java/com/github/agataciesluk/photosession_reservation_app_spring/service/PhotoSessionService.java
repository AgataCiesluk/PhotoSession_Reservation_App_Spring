package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.controller.ClientCreateForm;
import com.github.agataciesluk.photosession_reservation_app_spring.controller.PhotoSessionCreateForm;

public interface PhotoSessionService {

    PhotoSessionCreateForm createEmptyPhotoSessionToForm();
    void savePhotoSession(PhotoSessionCreateForm photoSessionCreateForm);
}
