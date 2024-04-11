package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.dto.TaiKhoanDTO;
import com.qlktx.qlktx.entities.Nguoidung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepo extends JpaRepository<Nguoidung, Integer> {
    Nguoidung findTopByTenDangNhap(String username);

}
