package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.ClientRepository;
import com.github.agataciesluk.photosession_reservation_app_spring.repository.UserRepository;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Client Basic Service specification")
@ExtendWith(SpringExtension.class)
@Import(ClientBasicService.class)
class ClientBasicServiceTest {

    @MockBean
    private ClientRepository clientRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientBasicService classUnderTest;

    @Test
    @DisplayName("Should return client for given email")
    public void getClientByEmail_success() {
        Mockito.when(clientRepository.findByEmail("agata@wp.pl"))
                .thenReturn(ClientEntity.builder()
                        .email("agata@wp.pl")
                        .firstName("Agata")
                        .lastName("Ciesluk")
                        .phoneNumber("555666999")
                        .build());

        ClientEntity resultClient = classUnderTest.getClientByEmail("agata@wp.pl");

        Truth.assertThat(resultClient).isEqualTo(ClientEntity.builder()
                .email("agata@wp.pl")
                .firstName("Agata")
                .lastName("Ciesluk")
                .phoneNumber("555666999")
                .build());
    }

}