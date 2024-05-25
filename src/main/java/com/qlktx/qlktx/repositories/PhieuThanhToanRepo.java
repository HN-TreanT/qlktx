package com.qlktx.qlktx.repositories;

import com.qlktx.qlktx.entities.Phieuthanhtoan;
import com.qlktx.qlktx.payloads.PhieuThanhToanRes;
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


    @Query(value = "WITH TotalDienNuoc AS (SELECT ma_phieu_thanh_toan, SUM(tong_tien) AS tongtienDiennuoc FROM sodiennuoc GROUP BY ma_phieu_thanh_toan),\n" +
            "TotalSuaChua AS (SELECT ma_phieu_thanh_toan, SUM(phi_sua_chua) AS tongtienSuachua FROM sosuachua GROUP BY ma_phieu_thanh_toan),\n" +
            "TotalPhat AS (SELECT ma_phieu_thanh_toan, SUM(phi_phat) AS tongtienPhat FROM phieuphat GROUP BY ma_phieu_thanh_toan)\n" +
            "SELECT ptt.ma_phieu_thanh_toan, ptt.ma_sinh_vien, ptt.so_phong, ptt.ngay_thu, ptt.noi_dung_thu, ptt.trang_thai, ptt.so_tien, \n" +
            "    COALESCE(td.tongtienDiennuoc, 0) AS tongtienDiennuoc, \n" +
            "    COALESCE(tsc.tongtienSuachua, 0) AS tongtienSuachua, \n" +
            "    COALESCE(tp.tongtienPhat, 0) AS tongtienPhat\n" +
            "FROM \n" +
            "    qlktx.phieuthanhtoan ptt\n" +
            "LEFT JOIN TotalDienNuoc td ON ptt.ma_phieu_thanh_toan = td.ma_phieu_thanh_toan\n" +
            "LEFT JOIN TotalSuaChua tsc ON ptt.ma_phieu_thanh_toan = tsc.ma_phieu_thanh_toan\n" +
            "LEFT JOIN TotalPhat tp ON ptt.ma_phieu_thanh_toan = tp.ma_phieu_thanh_toan\n" +
            "LEFT JOIN phong p ON p.so_phong = ptt.so_phong\n" +
            "where ptt.ma_hop_dong is null and (:soPhong is null or ptt.so_phong = :soPhong) and " +
            "(:timeStart is null or :timeEnd is null or (ptt.ngay_thu >= :timeStart and ptt.ngay_thu <= :timeEnd))\n" +
            "GROUP BY ptt.ma_phieu_thanh_toan, ptt.ma_sinh_vien, ptt.so_phong, ptt.ngay_thu, ptt.noi_dung_thu, ptt.trang_thai, ptt.so_tien, td.tongtienDiennuoc, tsc.tongtienSuachua, tp.tongtienPhat", nativeQuery = true)
    Page<PhieuThanhToanRes> getPhieuThanhToanPhong(@Param("soPhong") Integer soPhong,
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
