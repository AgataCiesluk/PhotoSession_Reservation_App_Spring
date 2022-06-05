package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findUserByUsername(String username);
    void saveUser(UserEntity user);
}
