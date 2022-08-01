package com.lecture.studyolle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) ->
                auth
                    .mvcMatchers("/", "/login", "/sign-up", "/check-email", "/check-email-token", "/email-login", "chech-email-login", "login-link")
                    .permitAll()
                    .mvcMatchers(HttpMethod.GET, "/profile/*")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
        ).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
