package com.qlktx.qlktx.utils.jwt;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService {
    UserDetailsService userDetailsService();
}
