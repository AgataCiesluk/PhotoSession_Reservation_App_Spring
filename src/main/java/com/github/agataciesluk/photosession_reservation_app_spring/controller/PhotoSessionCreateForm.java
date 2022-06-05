package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.validator.AttributeToCheck;
import com.github.agataciesluk.photosession_reservation_app_spring.validator.CheckUnique;
import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoTypeEntity;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoSessionCreateForm {

    @NotNull
    @CheckUnique(value = AttributeToCheck.DATE)
    private String date;
    @NotNull
    private String time;
    @NotNull
    private String area;
    @NotNull
    private String place;
    private String clientComment;
    private ClientEntity client;
    private PhotoTypeEntity photoType;
}
