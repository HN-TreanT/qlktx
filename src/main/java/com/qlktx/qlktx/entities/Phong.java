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

    @Column(name = "TenPhong", nullable = true)
    private String tenPhong;

    @Column(name = "SoTang", nullable = true)
    private Integer soTang;

    @Column(name = "SoNha", nullable = true)
    private String soNha;

    @Column(name = "SoNguoiO", nullable = true)
    private Integer soNguoiO;

    @Column(name = "trang_thai", nullable = true)
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "MaLoaiPhong", nullable = true)
    private Loaiphong loaiphong;

    @ManyToOne
    @JoinColumn(name = "MaTrgPhong")
    private Sinhvien truongphong;


}
