package com.qlktx.qlktx.security;

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.crypto.AlgorithmMethod;

import org.hibernate.mapping.Map;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenAuthencationFilter extends OncePerRequestFilter {
    private JwtConfig jwtConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String header = request.getHeader(jwtConfig.getHeader());
        chain.doFilter(request, response);

        if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
            chain.doFilter(request, response);
            return;
        }

        String token = header.replace(jwtConfig.getPrefix(), "");
        // Algorithm alogorithm = Algo

    }

    // private Map getClaim

    // private boolean isTokenExpired(String token) {
    // if(token.equals("") || token.equals(null)) return false;
    // Map claims;
    // try {

    // } catch (Exception e) {
    // return false;
    // }
    // BigDecimal a = new BigDecimal(claims.get("exp").toString());
    // long timeExpired = a.longValueExact() * 1000;
    // long timeNow = System.currentTimeMillis();
    // if(timeExpired <= timeNow) return true;
    // return false;
    // }
}
