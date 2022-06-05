package com.github.agataciesluk.photosession_reservation_app_spring.repository;

import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT c FROM ClientEntity c JOIN c.user u WHERE u.username = :username")
    ClientEntity customFindByUsername(@Param("username") String username);
    ClientEntity findByEmail(String email);
    ClientEntity findByPhoneNumber(String phoneNumber);
}
