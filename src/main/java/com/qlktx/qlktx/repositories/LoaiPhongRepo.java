package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.entities.Phong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiPhongRepo extends JpaRepository<Loaiphong, Integer> {
    Loaiphong findByMaLoaiPhong(Integer maLoaiPhong);
    public  void  deleteLoaiphongByMaLoaiPhong(Integer maLoaiPhong);
}
