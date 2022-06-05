package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.controller.PhotoSessionCreateForm;
import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoSessionEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.PhotoSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoSessionBasicService implements PhotoSessionService{

    private final PhotoSessionRepository photoSessionRepository;

    @Override
    public PhotoSessionCreateForm createEmptyPhotoSessionToForm() {
        return new PhotoSessionCreateForm();
    }

    @Override
    public void savePhotoSession(PhotoSessionCreateForm photoSessionCreateForm) {

        photoSessionRepository.save(PhotoSessionEntity.builder()
                        .date(photoSessionCreateForm.getDate())
                        .time(photoSessionCreateForm.getTime())
                        .area(photoSessionCreateForm.getArea())
                        .place(photoSessionCreateForm.getPlace())
                        .clientComment(photoSessionCreateForm.getClientComment())
                        .completed(false)
                        .client(photoSessionCreateForm.getClient())
                        .photoType(photoSessionCreateForm.getPhotoType())
                        .build());
    }

    @Override
    public List<PhotoSessionEntity> getAllPhotoSessSorted() {
        return photoSessionRepository.findAll();
    }

    @Override
    public List<PhotoSessionEntity> getAllFutureSessSorted() {
        return photoSessionRepository.customFindAllFutureSessSorted();
    }

    @Override
    public List<PhotoSessionEntity> getFutureSessByUsernameSorted(String username) {
        return photoSessionRepository.customFindFutureSessByUsernameSorted(username);
    }

    @Override
    public List<PhotoSessionEntity> getAllSessByUsernameSorted(String username) {
        return photoSessionRepository.customFindAllSessByUsernameSorted(username);
    }

    @Override
    public List<PhotoSessionEntity> getAllCompletedSessByUsernameSorted(String username) {
        return photoSessionRepository.customFindAllCompletedSessByUsernameSorted(username);
    }

    @Override
    public List<PhotoSessionEntity> getAllCompletedSess() {
        return photoSessionRepository.customFindAllCompletedSess();
    }

    @Override
    public PhotoSessionEntity getPhotoSessByDate(String date) {
        return photoSessionRepository.findByDate(date);
    }
}
