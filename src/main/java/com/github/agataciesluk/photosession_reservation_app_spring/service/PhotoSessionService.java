package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.controller.PhotoSessionCreateForm;
import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoSessionEntity;

import java.util.List;

public interface PhotoSessionService {

    PhotoSessionCreateForm createEmptyPhotoSessionToForm();
    void savePhotoSession(PhotoSessionCreateForm photoSessionCreateForm);
    List<PhotoSessionEntity> getAllPhotoSessSorted();
    List<PhotoSessionEntity> getAllFutureSessSorted();
    List<PhotoSessionEntity> getFutureSessByUsernameSorted(String username);
    List<PhotoSessionEntity> getAllSessByUsernameSorted(String username);
    List<PhotoSessionEntity> getAllCompletedSessByUsernameSorted(String username);
    List<PhotoSessionEntity> getAllCompletedSess();
    PhotoSessionEntity getPhotoSessByDate(String date);
}
