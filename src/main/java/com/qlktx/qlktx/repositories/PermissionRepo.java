package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Integer> {
}
