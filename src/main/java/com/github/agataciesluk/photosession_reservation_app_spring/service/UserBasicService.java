package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBasicService implements UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserBasicService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<UserEntity> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity findUserByRole(String role) {
        return userRepository.findByRole(role);
    }

    public void saveUser(UserEntity user) {
        userRepository.save(UserEntity.builder()
                .password(passwordEncoder.encode(user.getPassword()))
                .role(user.getRole())
                .username(user.getUsername())
                .build());
    }

    @Override
    public void createDefaultAdmin() {
        saveUser(UserEntity.builder()
                .username("admin")
                .role("ADMIN")
                .password("admin1234")
                .build());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
