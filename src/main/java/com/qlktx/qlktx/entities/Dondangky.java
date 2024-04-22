package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "dondangky")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dondangky {
    @Id
    @Column(name = "ma_don_dang_ky")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDonDangKy;

    @Column(name = "ngay_lam_don")
    private LocalDateTime ngayLamDon;

    @Column(name = "doi_tuong_uu_tien")
    private String doiTuongUuTien;

    @Column(name = "ho_ten_sinh_vien")
    private String hoTenSinhVien;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "loai_phong")
    private String loaiPhong;

    @Column(name = "so_thang")
    private Integer soThang;

    @ManyToOne
    @JoinColumn(name = "ma_sinh_vien")
    private Sinhvien sinhvien;

}
