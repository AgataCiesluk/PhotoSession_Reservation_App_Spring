package com.github.agataciesluk.photosession_reservation_app_spring.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 2, max = 30)
    private String username;
    @NotNull
    @Size(min = 8)
    private String password;
    private String role;
    @OneToOne(mappedBy = "user")
    private ClientEntity client;
}
