package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBasicService implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserEntity findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
