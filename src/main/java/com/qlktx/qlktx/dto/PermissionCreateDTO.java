package com.qlktx.qlktx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionCreateDTO {
    List<PermissionRoleDTO> permissionRoleDTOS;
}
