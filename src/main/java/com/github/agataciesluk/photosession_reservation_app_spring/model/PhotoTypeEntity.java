package com.github.agataciesluk.photosession_reservation_app_spring.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "photo_types")
public class PhotoTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @NotBlank
    private int numberOfPhotos;
//    @OneToMany
//    @JoinColumn(name = "photo_session_id")
//    private List<PhotoSessionEntity> photoSessions = new ArrayList<>();
}
