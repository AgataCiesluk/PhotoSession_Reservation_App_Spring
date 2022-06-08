package com.github.agataciesluk.photosession_reservation_app_spring.repository;

import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@DisplayName("Client repository specification")
class ClientRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Should find Client with given username")
    public void customFindByUsername_success() {
        UserEntity user = UserEntity.builder()
                .password("agata1234")
                .role("CLIENT")
                .username("agataKlientka")
                .build();

        ClientEntity client = ClientEntity.builder()
                .email("agata@wp.pl")
                .firstName("Agata")
                .lastName("Ciesluk")
                .phoneNumber("555666999")
                .user(user)
                .build();
        testEntityManager.persist(user);
        testEntityManager.persist(client);


        ClientEntity resultClient = clientRepository.customFindByUsername(user.getUsername());


        Truth.assertThat(resultClient).isEqualTo(client);
    }

    @Test
    @DisplayName("Should not find Client by username for not related User")
    public void customFindByUsername_nullClient() {
        UserEntity user = UserEntity.builder()
                .password("agata1234")
                .role("CLIENT")
                .username("agataKlientka")
                .build();

        ClientEntity client = ClientEntity.builder()
                .email("agata@wp.pl")
                .firstName("Agata")
                .lastName("Ciesluk")
                .phoneNumber("555666999")
                .user(null)
                .build();
        testEntityManager.persist(user);
        testEntityManager.persist(client);

        ClientEntity resultClient = clientRepository.customFindByUsername(user.getUsername());

        Truth.assertThat(resultClient).isNull();
    }
}