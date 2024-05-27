package com.qlktx.qlktx.exceptions;

import org.springframework.security.core.AuthenticationException;

public class authException extends AuthenticationException {
    public authException(String msg) {
        super(msg);
    }
}
