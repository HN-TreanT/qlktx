package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Data;

@Entity
@Table(name = "nguoidung")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nguoidung {
    @Id
    @Column(name = "ID_NV", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNv;

    @Column(name = "Ten_NV", nullable = true)
    private String tenNv;

    @Column(name = "SDT", nullable = true)
    private String sdt;

    @Column(name = "CCCD", nullable = true)
    private String cccd;

    @Column(name = "TenDangNhap", unique = true)
    private String tenDangNhap;

    @Column(name = "MatKhau", nullable = true)
    private String matKhau;

    @Column(name = "ChucVu", nullable = true)
    private String chucVu;

    @ManyToOne
    @JoinColumn(name = "ID_Nhom", nullable = true)
    private Nhomnguoidung nhomnguoidung;
}
