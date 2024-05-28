package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.PermissionCreateDTO;
import com.qlktx.qlktx.dto.PermissionRoleDTO;
import com.qlktx.qlktx.services.PermissionRoleService;
import com.qlktx.qlktx.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/permissionrole")
@CrossOrigin("*")
public class PermissionRoleController {

    @Autowired
    private PermissionRoleService permissionRoleService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(
                                          @RequestParam("id_nhomnguoidung") Integer id_nhomnguoidung) {
           return permissionRoleService.list(id_nhomnguoidung);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody List<PermissionRoleDTO> permissionCreateDTO) {
        return permissionRoleService.createMany(permissionCreateDTO);
    }

    @PostMapping("/edit")
    public ResponseEntity<Object> edit(@RequestBody List<PermissionRoleDTO> dtos) {
        return permissionRoleService.editMany(dtos);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(
            @RequestParam("id_permission") Integer id_permission,
            @RequestParam("id_nhomnguoidung") Integer id_nhomnguoidung
    ) {
        return permissionRoleService.deleteWithPermissionIdAndIdNhomNguoiDung(id_permission, id_nhomnguoidung);
    }
}
