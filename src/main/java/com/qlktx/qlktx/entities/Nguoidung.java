package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nguoidung")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nguoidung {
    @Id
    @Column(name = "ID_NV")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNv;

    @Column(name = "Ten_NV")
    private String tenNv;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "TenDangNhap")
    private String tenDangNhap;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "ChucVu")
    private String chucVu;

    @ManyToOne
    @JoinColumn(name = "ID_Nhom")
    private Nhomnguoidung nhomnguoidung;
}
