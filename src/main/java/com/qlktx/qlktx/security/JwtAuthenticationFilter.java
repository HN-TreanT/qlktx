//package com.qlktx.qlktx.security;
//
//import com.google.gson.Gson;
//import com.qlktx.qlktx.exceptions.authException;
//import com.qlktx.qlktx.utils.jwt.IJwtService;
//import com.qlktx.qlktx.utils.jwt.IUserService;
//import io.micrometer.common.util.StringUtils;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final IJwtService jwtService;
//    private final IUserService userService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, AuthenticationException {
//        try {
//
//            final String authHeader = request.getHeader("Authorization");
//            final String jwt;
//            final String userEmail;
//            String requestURI = request.getRequestURI();
//            if (requestURI.matches("/api/v1/nguoidung/.*")) {
//                filterChain.doFilter(request, response);
//                return;
//            }
//
//            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("Token is missing or invalid");
////                filterChain.doFilter(request, response);
//                return;
//            }
//
//            jwt = authHeader.substring(7);
//            if (!jwtService.isTokenExpired(jwt)) {
//                userEmail = jwtService.getUsernameFromJWT(jwt);
//
//
//                if (StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication() == null) {
//                    UserDetails userDetails = userService.userDetailsService().loadUserByUsername(userEmail);
////                    if (jwtService.validateToken(jwt, userDetails)) {
//                        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
//                        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                        securityContext.setAuthentication(token);
//                        SecurityContextHolder.setContext(securityContext);
//                }
//            } else {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("token expired");
//                return;
//            }
//            filterChain.doFilter(request, response);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            log.error("failed on set user authentication", ex.getMessage());
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            response.getWriter().write(ex.getMessage());
//            return;
//
//        }
//    }
//}
