package com.qlktx.qlktx.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bienbanbangiao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bienbanbangiao {
    @Id
    @Column(name = "MaBienBan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maBienBan;

    @Column(name = "NgayBanGiao")
    private LocalDateTime ngayBanGiao;

    @Column(name = "HoTenNguoiBanGiao")
    private String hoTenNguoiBanGiao;

    @Column(name = "HoTenSinhVien")
    private String hoTenSinhVien;

    // @Column(name = "MaSinhVien")
    // private Integer maSinhVien;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien")
    private Sinhvien maSinhVien;

}
