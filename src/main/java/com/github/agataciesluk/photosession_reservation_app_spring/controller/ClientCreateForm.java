package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.validator.AttributeToCheck;
import com.github.agataciesluk.photosession_reservation_app_spring.validator.CheckUnique;
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
    @CheckUnique(value = AttributeToCheck.EMAIL)
    private String email;
    @Size(min = 7, max = 15)
    @CheckUnique(value = AttributeToCheck.PHONE_NUMBER)
    private String phoneNumber;
    @NotNull
    @Size(min = 2, max = 30)
    @CheckUnique(value = AttributeToCheck.USERNAME)
    private String username;
    @NotNull
    @Size(min = 8)
    private String userPassword;
    private String userRole;
}
