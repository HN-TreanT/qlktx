package com.qlktx.qlktx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRoleDTO {
    private Integer id_permission;

    private Integer id_nhomnguoidung;

    private String action;
}
