package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.annotation.AttributeToCheck;
import com.github.agataciesluk.photosession_reservation_app_spring.annotation.CheckUnique;
import lombok.*;

import javax.persistence.Column;
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
    @CheckUnique(value = AttributeToCheck.EMAIL)
    private String email;
    @Size(min = 7, max = 15)
    @CheckUnique(value = AttributeToCheck.PHONE_NUMBER)
    private String phoneNumber;
    @NotNull
    @Size(min = 2, max = 30)
    @CheckUnique(value = AttributeToCheck.USER_LOGIN)
    private String userLogin;
    @NotNull
    @Size(min = 8, max = 50)
    private String userPassword;
    private String userRole;
}
