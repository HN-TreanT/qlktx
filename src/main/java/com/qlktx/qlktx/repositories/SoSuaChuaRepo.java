package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Sosuachua;
import com.qlktx.qlktx.payloads.ThongKeDienNuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface SoSuaChuaRepo extends JpaRepository<Sosuachua, Integer> {

    @Query("select sosuachua from Sosuachua sosuachua  where :soPhong is null  or sosuachua.phong.soPhong = :soPhong")
    Page<Sosuachua> getListSoSuaChua(@Param("soPhong") Integer soPhong, Pageable pageable);

    List<Sosuachua> findAllByMaPhieuThanhToan(Integer maPhieuThanhToan);

    @Modifying
    @Query("UPDATE Sosuachua set trangThai = 1 where maPhieuThanhToan = :maPhieuThanhToan")
    void updateThanhToan(@Param("maPhieuThanhToan") Integer maPhieuThanhToan);

    @Query(value = "SELECT \n" +
            "    YEAR(ngay_di_sua) AS nam,\n" +
            "    MONTH(ngay_di_sua) AS thang,\n" +
            "    sum(phi_sua_chua) as tong_tien\n" +
            "FROM \n" +
            "    sosuachua\n" +
            "GROUP BY \n" +
            "    YEAR(ngay_di_sua), MONTH(ngay_di_sua)\n" +
            "ORDER BY \n" +
            "    nam, thang;", nativeQuery = true)
    Collection<ThongKeDienNuoc> thogke();
}
