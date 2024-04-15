package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phong")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phong {
    @Id
    @Column(name = "SoPhong")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer soPhong;

    @Column(name = "TenPhong")
    private String tenPhong;

    @Column(name = "SoTang")
    private Integer soTang;

    @Column(name = "SoNha")
    private String soNha;

    @Column(name = "SoNguoiO")
    private Integer soNguoiO;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "MaLoaiPhong")
    private Loaiphong loaiphong;

    @ManyToOne
    @JoinColumn(name = "MaTrgPhong")
    private Sinhvien truongphong;


}
