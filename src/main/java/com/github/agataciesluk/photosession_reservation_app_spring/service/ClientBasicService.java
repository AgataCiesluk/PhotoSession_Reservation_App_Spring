package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.controller.ClientCreateForm;
import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.ClientRepository;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class ClientBasicService implements ClientService{

    private static final String ROLE = "CLIENT";
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientCreateForm createEmptyClientToForm() {
        return new ClientCreateForm();
    }

    @Override
    public void saveClient(ClientCreateForm clientCreateForm) {
        UserEntity newUser = userRepository.save(UserEntity.builder()
                        .username(clientCreateForm.getUsername())
                        .password(passwordEncoder.encode(clientCreateForm.getUserPassword()))
                        .role(ROLE)
                        .build());

        clientRepository.save(ClientEntity.builder()
                        .firstName(clientCreateForm.getFirstName())
                        .lastName(clientCreateForm.getLastName())
                        .email(clientCreateForm.getEmail())
                        .phoneNumber(clientCreateForm.getPhoneNumber())
                        .user(newUser)
                        .build());
    }

    @Override
    public ClientEntity getClientByUsername(String username) {
        ClientEntity client = clientRepository.customFindByUsername(username);
        log.info("Found client with username = {}: {}", username, client);
        return client;
    }

    @Override
    public ClientEntity getClientByEmail(String email) {
        ClientEntity client = clientRepository.findByEmail(email);
        log.info("Found client with email = {}: {}", email, client);
        return client;
    }

    @Override
    public ClientEntity getClientByPhoneNumber(String phoneNumber) {
        ClientEntity client = clientRepository.findByPhoneNumber(phoneNumber);
        log.info("Found client with phone number = {}: {}", phoneNumber, client);
        return client;
    }
}
