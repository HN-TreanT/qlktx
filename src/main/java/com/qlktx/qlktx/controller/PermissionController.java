package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/permission")
@CrossOrigin("*")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        return permissionService.list();
    }
}
