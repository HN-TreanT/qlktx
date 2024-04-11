package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Nhomnguoidung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhomNguoiDungRepo extends JpaRepository<Nhomnguoidung, Integer> {
}
