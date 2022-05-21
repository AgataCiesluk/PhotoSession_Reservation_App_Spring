package com.github.agataciesluk.photosession_reservation_app_spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "photo_sessions")
public class PhotoSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String type;

    @NotBlank
    private int numberOfPhotos;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime time;

    @NotNull
    private String area;

    @NotNull
    private String place;
    
    private String clientComment;

    private boolean dateAvailable;
    private boolean completed;
}
