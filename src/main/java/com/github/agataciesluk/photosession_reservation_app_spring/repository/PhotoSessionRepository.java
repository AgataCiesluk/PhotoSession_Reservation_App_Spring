package com.github.agataciesluk.photosession_reservation_app_spring.repository;

import com.github.agataciesluk.photosession_reservation_app_spring.model.PhotoSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoSessionRepository extends JpaRepository<PhotoSessionEntity, Long> {

    @Query("SELECT pse FROM PhotoSessionEntity pse WHERE pse.date >= CURRENT_DATE ORDER BY pse.date") //jesli zapytanie nie zadziala sprobuj z LOCAL_DATE lub spojrz na strone:
    //https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#jpql-standardized-functions
    List<PhotoSessionEntity> customFindAllFutureSessSorted();

    @Query("SELECT pse FROM PhotoSessionEntity pse WHERE pse.client.user.username = :username AND pse.date >= CURRENT_DATE ORDER BY pse.date")
    List<PhotoSessionEntity> customFindFutureSessByUsernameSorted(@Param("username") String username);

    @Query("SELECT pse FROM PhotoSessionEntity pse WHERE pse.client.user.username = :username ORDER BY pse.date")
    List<PhotoSessionEntity> customFindAllSessByUsernameSorted(@Param("username")String username);

    @Query("SELECT pse FROM PhotoSessionEntity pse WHERE pse.client.user.username = :username AND pse.completed = true ORDER BY pse.date")
    List<PhotoSessionEntity> customFindAllCompletedSessByUsernameSorted(@Param("username")String username);

    @Query("SELECT pse FROM PhotoSessionEntity pse WHERE pse.completed = true ORDER BY pse.date")
    List<PhotoSessionEntity> customFindAllCompletedSess();

    PhotoSessionEntity findByDate(String date);
}
