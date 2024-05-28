package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Sodiennuoc;
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
public interface SoDienNuocRepo extends JpaRepository<Sodiennuoc, Integer> {
    @Query("select so from Sodiennuoc so  where :soPhong is null  or so.phong.soPhong = :soPhong")
    Page<Sodiennuoc> getListSoDieNuoc(@Param("soPhong") Integer soPhong, Pageable pageable);

    List<Sodiennuoc> findAllByMaPhieuThanhToan(Integer maPhieuThanhToan);
    
    @Modifying
    @Query("UPDATE Sodiennuoc set trangThai = 1 where maPhieuThanhToan = :maPhieuThanhToan")
    void updateThanhToan(@Param("maPhieuThanhToan") Integer maPhieuThanhToan);


    @Query(value = "SELECT \n" +
            "    YEAR(thang) AS nam,\n" +
            "    MONTH(thang) AS thang,\n" +
            "    sum(chi_so_dien) AS tong_dien,\n" +
            "    sum(chi_so_nuoc) AS tong_nuoc\n" +
            "FROM \n" +
            "    sodiennuoc\n" +
            "GROUP BY \n" +
            "    YEAR(thang), MONTH(thang)\n" +
            "ORDER BY \n" +
            "    nam, thang", nativeQuery = true)
    Collection<ThongKeDienNuoc> thongkediennuoc();


}
