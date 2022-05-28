package com.github.agataciesluk.photosession_reservation_app_spring.controller;

import com.github.agataciesluk.photosession_reservation_app_spring.model.ClientEntity;
import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoTypeEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoSessionCreateForm {

    @NotNull
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
