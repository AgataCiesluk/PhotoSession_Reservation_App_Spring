package com.github.agataciesluk.photosession_reservation_app_spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    @NotNull
    @Email
    private String email;
    @Size(min = 7, max = 15)
    private int phoneNumber;
    @OneToOne(mappedBy = "client")
    private UserEntity user;
    @OneToMany(mappedBy = "client")
    private List<PhotoSessionEntity> photoSessions = new ArrayList<>();
}
