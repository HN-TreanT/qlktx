package com.qlktx.qlktx.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface PermissionService {
    ResponseEntity<Object> list();
}
