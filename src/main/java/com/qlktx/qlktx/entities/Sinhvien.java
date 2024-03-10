package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "HoTenSinhVien")
    private String hoTenSinhVien;

    @Column(name = "NgaySinh")
    private java.sql.Date ngaySinh;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "Lop")
    private String lop;

    @Column(name = "Khoa")
    private String khoa;

    @Column(name = "KhoaHoc")
    private Integer khoaHoc;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "Email")
    private String email;

    @Column(name = "DiaChiThuongTru")
    private String diaChiThuongTru;

//    @Column(name = "SoPhong")
//    private Integer soPhong;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

}
