package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.entities.Permission;
import com.qlktx.qlktx.repositories.PermissionRepo;
import com.qlktx.qlktx.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepo permissionRepo;
    @Override
    public ResponseEntity<Object> list() {
        List<Permission> res = permissionRepo.findAll();
        return ResponseEntity.ok(res);
    }
}
