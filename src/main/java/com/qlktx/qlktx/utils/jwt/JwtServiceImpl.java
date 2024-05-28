package com.qlktx.qlktx.utils.jwt;

import com.qlktx.qlktx.entities.Nguoidung;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtServiceImpl implements IJwtService {
    private final String SECRET_KEY = "hoangnam";
    private final String REFRESH_KEY = "hoangnam_refresh";


    @Override
    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return String.format(claims.getSubject());

    }

    @Override
    public String getUsernameFromRefreshtoken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(REFRESH_KEY).parseClaimsJws(token).getBody();
        return String.format(claims.getSubject());

    }

    @Override
    public String generateToken(Nguoidung nguoidung) {
        return Jwts.builder()
                .setSubject(nguoidung.getTenDangNhap())
                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .setExpiration(new Date(System.currentTimeMillis() + 60*1000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    @Override
    public String generateRefreshToken(Nguoidung nguoidung) {
        return Jwts.builder()
                .setSubject(nguoidung.getTenDangNhap())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 30))
                .signWith(SignatureAlgorithm.HS256, REFRESH_KEY)
                .compact();
    }

    @Override
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    @Override
    public boolean validateRefreshToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(REFRESH_KEY).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    // extraction claims
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
//
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // checking expiration
    public Date getExpirationDateFromToken(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    @Override
    public Boolean isTokenExpired(String token) {
        try {
            final Date expiration = getExpirationDateFromToken(token);
            return expiration.before(new Date());
        } catch (Exception ex) {
            return  false;
        }

    }

    // validation token
    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
      try {
//          final String username = getUsernameFromJWT(token);
//          return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
          return  !isTokenExpired(token);
      } catch (Exception ex) {
         log.error("token expired");
      }
      return false;
    }
}
