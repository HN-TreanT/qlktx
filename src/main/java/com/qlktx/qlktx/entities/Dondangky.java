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

    @Column(name = "NgayLamDon", nullable = true)
    private LocalDateTime ngayLamDon;

    @Column(name = "DoiTuongUuTien", nullable = true)
    private String doiTuongUuTien;

    @Column(name = "HoTenSinhVien", nullable = true)
    private String hoTenSinhVien;

    @Column(name = "TrangThai", nullable = true)
    private String trangThai;

    @Column(name = "LoaiPhong", nullable = true)
    private String loaiPhong;

    @Column(name = "SoThang", nullable = true)
    private Integer soThang;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien", nullable = true)
    private Sinhvien sinhvien;

}
