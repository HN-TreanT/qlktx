package com.qlktx.qlktx.utils.jwt;

import com.qlktx.qlktx.entities.Nguoidung;
import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    String getUsernameFromJWT(String token);

    String generateToken(Nguoidung nguoidung);

    Boolean validateToken(String token, UserDetails userDetails);

    Boolean isTokenExpired(String token);
//         boolean validateToken(String token);
}
