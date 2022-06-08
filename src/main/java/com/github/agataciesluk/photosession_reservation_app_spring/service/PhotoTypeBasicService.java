package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoTypeEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.PhotoTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoTypeBasicService implements PhotoTypeService {

    private final PhotoTypeRepository photoTypeRepository;

    @Override
    public List<PhotoTypeEntity> getAllPhotoTypes() {
        return photoTypeRepository.findAll();
    }
}
