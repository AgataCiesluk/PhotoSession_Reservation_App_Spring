package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoTypeEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.validator.AttributeToCheck;
import com.github.agataciesluk.photosession_reservation_app_spring.validator.CheckUnique;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoSessionCreateForm {

    @NotEmpty
    @CheckUnique(value = AttributeToCheck.DATE)
    private String date;
    @NotEmpty
    private String time;
    @NotEmpty
    private String area;
    @NotEmpty
    private String place;
    private String clientComment;
    private ClientEntity client;
    private PhotoTypeEntity photoType;
}
