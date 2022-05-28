package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.controller.ClientCreateForm;
import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.ClientRepository;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientBasicService implements ClientService{

    private static final String ROLE = "CLIENT";
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

    @Override
    public ClientCreateForm createEmptyClient() {
        return new ClientCreateForm();
    }

    @Override
    public void saveClient(ClientCreateForm clientCreateForm) {
        UserEntity newUser = userRepository.save(UserEntity.builder()
                        .login(clientCreateForm.getUserLogin())
                        .password(clientCreateForm.getUserPassword())
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

    public ClientEntity getClientByUserLogin(String userLogin) {
        return clientRepository.customFindByUserLogin(userLogin);
    }
}
