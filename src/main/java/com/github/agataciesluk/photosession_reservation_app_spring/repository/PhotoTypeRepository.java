package com.github.agataciesluk.photosession_reservation_app_spring.repository;

import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoTypeRepository extends JpaRepository<PhotoTypeEntity, Long> {
}
