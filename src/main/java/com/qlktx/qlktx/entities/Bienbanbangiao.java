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

    @Column(name = "NgayBanGiao", nullable = true)
    private LocalDateTime ngayBanGiao;

    @Column(name = "HoTenNguoiBanGiao", nullable = true)
    private String hoTenNguoiBanGiao;

    @Column(name = "HoTenSinhVien", nullable = true)
    private String hoTenSinhVien;

    // @Column(name = "MaSinhVien")
    // private Integer maSinhVien;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien", nullable = true)
    private Sinhvien maSinhVien;

}
