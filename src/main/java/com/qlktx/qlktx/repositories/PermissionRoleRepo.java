package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Permission;
import com.qlktx.qlktx.entities.PermissionRole;
import com.qlktx.qlktx.payloads.PermissionRes;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PermissionRoleRepo extends JpaRepository<PermissionRole, Integer> {
    @Query("select pr from PermissionRole  pr where pr.id_nhomnguoidung = :id_nhomnguoidung and pr.id_permission = :id_permission")
    List<PermissionRole> findAllByPermissionAndIdNhomNguoidung(@Param("id_nhomnguoidung") Integer id_nhomnguoidung, @Param("id_permission") Integer id_permission);

    @Query(value = "select p.id, p.name, p.code,  GROUP_CONCAT(pr.action) AS actions from permisstion_role pr \n" +
            "join permission p on p.id = pr.id_permission\n" +
            "where pr.id_nhomnguoidung = :id_nhomnguoidung\n" +
            "group by p.id, p.name, p.code ", nativeQuery = true)
    Collection<PermissionRes> listAllPermission(@Param("id_nhomnguoidung") Integer id_nhomnguoidung);

}
