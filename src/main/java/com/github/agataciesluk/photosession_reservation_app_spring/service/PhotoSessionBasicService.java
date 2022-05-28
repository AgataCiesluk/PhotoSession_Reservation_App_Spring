package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.controller.PhotoSessionCreateForm;
import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoSessionEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.PhotoSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        int numOfPhotosDependingOnType = 50; //I will have to create a method to get numberOfPhotos based on photoSession type
        photoSessionRepository.save(PhotoSessionEntity.builder()
                        .type(photoSessionCreateForm.getType())
                        .numberOfPhotos(numOfPhotosDependingOnType)
                        .date(photoSessionCreateForm.getDate())
                        .time(photoSessionCreateForm.getTime())
                        .area(photoSessionCreateForm.getArea())
                        .clientComment(photoSessionCreateForm.getClientComment())
                        .completed(false)
                        .build());
    }
}
