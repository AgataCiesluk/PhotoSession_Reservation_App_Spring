package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientCreateForm {

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
    @NotNull
    @Size(min = 2, max = 30)
    private String userLogin;
    @NotNull
    @Size(min = 8, max = 50)
    private String userPassword;
    private String userRole;
}
