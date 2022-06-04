package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserBasicService implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserEntity findUserByLogin(String login) {
        UserEntity user = userRepository.findByLogin(login);
        log.info("Found user: {}", user);
        return user;
    }
}
