package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private java.sql.Date ngayLamDon;

    @Column(name = "DoiTuongUuTien")
    private String doiTuongUuTien;

    @Column(name = "HoTenSinhVien")
    private String hoTenSinhVien;
    @ManyToOne
    @JoinColumn(name = "MaSinhVien")
    private Sinhvien sinhvien;

}
