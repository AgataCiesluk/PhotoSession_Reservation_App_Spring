package com.github.agataciesluk.photosession_reservation_app_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class AuthService implements UserDetailsService {

    private UserBasicService userBasicService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userBasicService.findUserByUsername(username)
                .map(userEntity -> new CurrentUser(
                        userEntity.getUsername(),
                        userEntity.getPassword(),
                        List.of(new SimpleGrantedAuthority(userEntity.getRole())),
                        userEntity))
                .orElseThrow(() -> new UsernameNotFoundException("No user with login " + username));
    }

    @Autowired
    public void setUserBasicService(UserBasicService userBasicService) {
        this.userBasicService = userBasicService;
    }
}
