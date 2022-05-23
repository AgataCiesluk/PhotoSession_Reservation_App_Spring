package com.github.agataciesluk.photosession_reservation_app_spring.repository;

import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
