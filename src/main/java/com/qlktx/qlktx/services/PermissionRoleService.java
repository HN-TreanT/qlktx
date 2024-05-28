package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.PermissionRoleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PermissionRoleService {
    ResponseEntity<Object> createMany(List<PermissionRoleDTO> list);
    ResponseEntity<Object> editMany(List<PermissionRoleDTO> list);
    ResponseEntity<Object> list(Integer id_nhomnguoidung);
    ResponseEntity<Object> deleteWithPermissionIdAndIdNhomNguoiDung(Integer id_permission, Integer id_nhomnguoiddung);
}
