package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.dto.PermissionRoleDTO;
import com.qlktx.qlktx.entities.Permission;
import com.qlktx.qlktx.entities.PermissionRole;
import com.qlktx.qlktx.mapper.PermissionRoleMapper;
import com.qlktx.qlktx.payloads.PermissionRes;
import com.qlktx.qlktx.repositories.PermissionRoleRepo;
import com.qlktx.qlktx.services.PermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class PermissionRoleServiceImpl implements PermissionRoleService {

    @Autowired
    private PermissionRoleMapper permissionRoleMapper;

    @Autowired
    private PermissionRoleRepo permissionRoleRepo;

    @Override
    public ResponseEntity<Object> createMany(List<PermissionRoleDTO> list) {
        List<PermissionRole> list1 = permissionRoleMapper.toEntities(list);
        System.out.println(list1);
        permissionRoleRepo.saveAll(list1);
        return ResponseEntity.ok(list1);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> editMany(List<PermissionRoleDTO> list) {

        if (list.size() < 0) return new ResponseEntity("array empty", HttpStatus.NOT_FOUND);
        PermissionRoleDTO permissionRoleDTO =  list.get(0);
        List<PermissionRole> permissionsOld = permissionRoleRepo.findAllByPermissionAndIdNhomNguoidung(permissionRoleDTO.getId_nhomnguoidung(), permissionRoleDTO.getId_permission());
        permissionRoleRepo.deleteAll(permissionsOld);

        List<PermissionRole> permissionNews = permissionRoleMapper.toEntities(list);
        permissionRoleRepo.saveAll(permissionNews);
        return ResponseEntity.ok(permissionNews);

    }

    @Override
    public ResponseEntity<Object> list(Integer id_nhomnguoidung) {

        Collection<PermissionRes> permissionsOld = permissionRoleRepo.listAllPermission(id_nhomnguoidung);
        return ResponseEntity.ok(permissionsOld);
    }

    @Override
    public ResponseEntity<Object> deleteWithPermissionIdAndIdNhomNguoiDung(Integer id_permission, Integer id_nhomnguoiddung) {
        List<PermissionRole> permissionsOld = permissionRoleRepo.findAllByPermissionAndIdNhomNguoidung(id_nhomnguoiddung, id_permission);
        permissionRoleRepo.deleteAll(permissionsOld);
        return ResponseEntity.ok("success");
    }
}
