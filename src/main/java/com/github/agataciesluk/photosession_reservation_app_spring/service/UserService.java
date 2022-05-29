package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;

public interface UserService {

    UserEntity findUserByLogin(String login);
}
