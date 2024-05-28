package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.payloads.ThogKePhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface LoaiPhongRepo extends JpaRepository<Loaiphong, Integer> {
    Loaiphong findByMaLoaiPhong(Integer maLoaiPhong);
    public  void  deleteLoaiphongByMaLoaiPhong(Integer maLoaiPhong);

    @Query(value = "SELECT lp.ma_loai_phong, lp.ten_loai_phong, count(p.so_nguoio) as tongSoNguoi FROM qlktx.loaiphong lp\n" +
            "left join phong p on p.ma_loai_phong = lp.ma_loai_phong\n" +
            "group by lp.ma_loai_phong, lp.ten_loai_phong", nativeQuery = true)
    Collection<ThogKePhong> thongke();
}
