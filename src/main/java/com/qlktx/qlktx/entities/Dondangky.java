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
    @Column(name = "MaDonDangKy")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDonDangKy;

    @Column(name = "NgayLamDon")
    private LocalDateTime ngayLamDon;

    @Column(name = "DoiTuongUuTien")
    private String doiTuongUuTien;

    @Column(name = "HoTenSinhVien")
    private String hoTenSinhVien;

    @Column(name = "TrangThai")
    private String trangThai;

    @Column(name = "LoaiPhong")
    private String loaiPhong;

    @Column(name = "SoThang")
    private Integer soThang;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien")
    private Sinhvien sinhvien;

}
