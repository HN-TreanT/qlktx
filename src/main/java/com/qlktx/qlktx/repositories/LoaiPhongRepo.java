package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.entities.Phong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiPhongRepo extends JpaRepository<Loaiphong, Long> {
    Loaiphong findByMaLoaiPhong(Integer maLoaiPhong);
    List<Loaiphong> findByTenLoaiPhongLikeAndSoLuongNguoi(String tenLoaiPhong, Integer  soLuongNguoi);
    public  void  deleteLoaiphongByMaLoaiPhong(Integer maLoaiPhong);
}
