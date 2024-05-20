package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Phieuthanhtoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PhieuThanhToanRepo extends JpaRepository<Phieuthanhtoan, Integer> {

    @Query("select ptt from Phieuthanhtoan ptt where " +
            "(:soPhong is null or ptt.phong.soPhong = :soPhong) and " +
            "(:timeStart is null or :timeEnd is null or (ptt.ngayThu >= :timeStart and ptt.ngayThu <= :timeEnd))")
    Page<Phieuthanhtoan> getListPhieuThanhToan(@Param("soPhong") Integer soPhong,
                                               @Param("timeStart") LocalDateTime timeStart,
                                               @Param("timeEnd") LocalDateTime timeEnd , Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO phieuthanhtoan (noi_dung_thu, ngay_thu, so_tien, ma_hop_dong, so_phong, ma_sinh_vien, ma_phieu_phat, ma_so_sua_chua, ma_so_dien_nuoc) " +
            "VALUES (:noiDungThu, :ngayThu, :soTien, :maHopDong, :maPhong, :maSinhVien, :maPhieuPhat, :maSoSuaChua, :maSoDienNuoc)", nativeQuery = true)
    void insertPhieuThanhToan(@Param("noiDungThu") String noiDungThu,
                              @Param("ngayThu") LocalDateTime ngayThu,
                              @Param("soTien") Float soTien,
                              @Param("maHopDong") Integer maHopDong,
                              @Param("maPhong") Integer maPhong,
                              @Param("maSinhVien") Integer maSinhVien,
                              @Param("maPhieuPhat") Integer maPhieuPhat,
                              @Param("maSoSuaChua") Integer maSoSuaChua,
                              @Param("maSoDienNuoc") Integer maSoDienNuoc);

    @Modifying
    @Query(value = "UPDATE phieuthanhtoan SET noi_dung_thu = :noiDungThu, ngay_thu = :ngayThu, so_tien = :soTien, " +
            "ma_hop_dong = :maHopDong, so_phong = :maPhong, ma_sinh_vien = :maSinhVien, " +
            "ma_phieu_phat = :maPhieuPhat, ma_so_sua_chua = :maSoSuaChua, ma_so_dien_nuoc = :maSoDienNuoc " +
            "WHERE ma_phieu_thanh_toan = :maPhieuThanhToan", nativeQuery = true)
    void updatePhieuThanhToan(@Param("maPhieuThanhToan") Integer maPhieuThanhToan,
                              @Param("noiDungThu") String noiDungThu,
                              @Param("ngayThu") LocalDateTime ngayThu,
                              @Param("soTien") Float soTien,
                              @Param("maHopDong") Integer maHopDong,
                              @Param("maPhong") Integer maPhong,
                              @Param("maSinhVien") Integer maSinhVien,
                              @Param("maPhieuPhat") Integer maPhieuPhat,
                              @Param("maSoSuaChua") Integer maSoSuaChua,
                              @Param("maSoDienNuoc") Integer maSoDienNuoc);

    @Query("select ppt from Phieuthanhtoan ppt  where  ppt.phong.soPhong = :maPhong order by ppt.ngayThu desc limit 1")
    Phieuthanhtoan getPhieuthanhtoanByPhong(@Param("maPhong") Integer maPhong);

}
