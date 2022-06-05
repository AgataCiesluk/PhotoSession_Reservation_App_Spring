package com.github.agataciesluk.photosession_reservation_app_spring.repository;

import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
