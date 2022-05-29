package com.github.agataciesluk.photosession_reservation_app_spring.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "photo_sessions")
public class PhotoSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String date;
    @NotNull
    private String time;
    @NotNull
    private String area;
    @NotNull
    private String place;
    private String clientComment;
    private boolean completed;
    @ManyToOne
    private ClientEntity client;
    @OneToOne//-->zmienic na @ManyToOne
    @JoinColumn(name = "photoType_id")
    private PhotoTypeEntity photoType;
}
