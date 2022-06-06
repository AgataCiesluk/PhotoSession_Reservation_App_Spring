package com.github.agataciesluk.photosession_reservation_app_spring.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty
    private String date;
    @NotEmpty
    private String time;
    @NotEmpty
    private String area;
    @NotEmpty
    private String place;
    private String clientComment;
    private boolean completed;
    @ManyToOne
    private ClientEntity client;
    @ManyToOne
    @JoinColumn(name = "photo_type_id")
    private PhotoTypeEntity photoType;
}
