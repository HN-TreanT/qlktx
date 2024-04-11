package com.qlktx.qlktx.security;

import com.qlktx.qlktx.services.impl.UserServices;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfig  {

    @Autowired
    private UserServices userServices;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
            http.cors(Customizer.withDefaults()).csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth ->
                            auth
                                    .requestMatchers("/api/v1/nguoidung/**").permitAll()
                                    .requestMatchers("/api/**").authenticated()

                    );
            http.addFilterBefore(new JwtTokenAuthencationFilter(), BasicAuthenticationFilter.class);
            return http.build();
    }


}
