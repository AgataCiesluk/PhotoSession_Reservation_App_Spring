package com.github.agataciesluk.photosession_reservation_app_spring.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "users")
@EqualsAndHashCode(of = "id")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 2, max = 30)
    private String login;
    @NotNull
    @Size(min = 8, max = 50)
    private String password;
    private String role;
    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}
