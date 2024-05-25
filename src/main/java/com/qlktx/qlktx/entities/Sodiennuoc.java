package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sodiennuoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sodiennuoc {
    @Id
    @Column(name = "MaSoDienNuoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSoDienNuoc;

    @Column(name = "DonGiaDien", nullable = true)
    private Float donGiaDien;

    @Column(name = "DonGiaNuoc", nullable = true)
    private Float donGiaNuoc;

    @Column(name = "ChiSoDien", nullable = true)
    private Integer chiSoDien;

    @Column(name = "ChiSoNuoc", nullable = true)
    private Integer chiSoNuoc;

    @Column(name = "Thang", nullable = true)
    private LocalDateTime thang;

    @Column(name = "tong_tien", nullable = true)
    private Float tongTien;

    @Column(name = "trang_thai", nullable = true)
    private Float trangThai;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

    //FK
    @Column(name = "ma_phieu_thanh_toan")
    private Integer maPhieuThanhToan;

}
