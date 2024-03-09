package com.qlktx.qlktx.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {
    @Autowired
    private JwtConfig jwtConfig;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults()).csrf(csrf -> csrf.disable())
                // .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig) ,
                // UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
                        // .requestMatchers("/api/**").hasRole("superadmin")
                        // .requestMatchers(HttpMethod.GET,"/api/**").authenticated()
                        // .requestMatchers("/api/v1/auth/**").permitAll()
                        // .anyRequest().permitAll());
                        .anyRequest().permitAll());
        return http.build();
    }

}
