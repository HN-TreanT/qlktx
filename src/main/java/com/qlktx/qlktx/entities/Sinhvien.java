package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sinhvien")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sinhvien {
    @Id
    @Column(name = "MaSinhVien")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSinhVien;

    @Column(name = "HoTenSinhVien", nullable = true)
    private String hoTenSinhVien;

    @Column(name = "NgaySinh", nullable = true)
    private LocalDateTime ngaySinh;

    @Column(name = "GioiTinh", nullable = true)
    private String gioiTinh;

    @Column(name = "CCCD", nullable = true)
    private String cccd;

    @Column(name = "Lop", nullable = true)
    private String lop;

    @Column(name = "Khoa", nullable = true)
    private String khoa;

    @Column(name = "KhoaHoc", nullable = true)
    private Integer khoaHoc;

    @Column(name = "SDT", nullable = true)
    private String sdt;

    @Column(name = "Email", nullable = true)
    private String email;

    @Column(name = "DiaChiThuongTru", nullable = true)
    private String diaChiThuongTru;

//    @Column(name = "SoPhong")
//    private Integer soPhong;

    @ManyToOne
    @JoinColumn(name = "SoPhong", nullable = true)
    private Phong phong;

}
