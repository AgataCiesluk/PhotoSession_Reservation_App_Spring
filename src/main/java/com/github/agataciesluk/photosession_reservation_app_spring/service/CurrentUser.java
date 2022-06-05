package com.github.agataciesluk.photosession_reservation_app_spring.service;

import com.github.agataciesluk.photosession_reservation_app_spring.model.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    private final UserEntity userEntity;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       UserEntity userEntity) {
        super(username, password, authorities);
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }
}
