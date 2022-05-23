package com.github.agataciesluk.photosession_reservation_app_spring.repository;

import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoSessionRepository extends JpaRepository<PhotoSessionEntity, Long> {
}
