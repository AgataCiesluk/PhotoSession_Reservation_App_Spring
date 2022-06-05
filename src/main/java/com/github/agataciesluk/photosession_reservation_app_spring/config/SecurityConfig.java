package com.github.agataciesluk.photosession_reservation_app_spring.config;


import com.github.agataciesluk.photosession_reservation_app_spring.service.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthService authService() {
        return new AuthService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/client/create").permitAll()
                .antMatchers("/client/session-add").hasAuthority("CLIENT")
                .antMatchers("/admin/sess-complete", "/admin/all-clients").hasAuthority("ADMIN")
                .antMatchers("/photo-sess/**").authenticated()
                .antMatchers("/homepage").authenticated()
                .and()
                .csrf()
                .disable()
                .formLogin()
                .loginPage("/login") // domyślny, adres pod którym będzie dostęny formularz logowania, robimy do tego kontroler, który wystawia stornę z formularzem ALE TYLKO NA @GetMapping, nie robimy @PostMapping w ogóle. Formularz ma odesłać żądanie POST na "/login"
                .usernameParameter("username") // domyślny, nazwa pola w formularzu logowania dla nazwy użytkownika
                .passwordParameter("password") // domyślny, nazwa pola w formularzu logowania dla hasła
                .defaultSuccessUrl("/homepage", true) // strona, na którą trafi użytkownik, jeżeli wszedł bezpośrednio na ścieżkę /login, aby się zalogować
//                .defaultSuccessUrl("/homepage", true) // wymusza, że po zalogowaniu ZAWSZE trafia się na wskazaną stronę.
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}
