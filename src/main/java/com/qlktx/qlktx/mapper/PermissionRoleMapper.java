package com.qlktx.qlktx.mapper;

import com.qlktx.qlktx.dto.PermissionRoleDTO;
import com.qlktx.qlktx.entities.Permission;
import com.qlktx.qlktx.entities.PermissionRole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionRoleMapper {
    List<PermissionRole> toEntities(List<PermissionRoleDTO> dtos);
}
