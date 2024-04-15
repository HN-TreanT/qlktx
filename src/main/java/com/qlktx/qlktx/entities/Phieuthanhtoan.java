package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "phieuthanhtoan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phieuthanhtoan {
    @Id
    @Column(name = "MaPhieuThanhToa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maPhieuThanhToa;

    @Column(name = "NoiDungThu")
    private String noiDungThu;

    @Column(name = "NgayThu")
    private LocalDateTime ngayThu;

    @Column(name = "SoTien")
    private Float soTien;

//    @Column(name = "SoPhong")
//    private Integer soPhong;
//
//    @Column(name = "MaSinhVien")
//    private Integer maSinhVien;
//
//    @Column(name = "MaHopDong")
//    private Integer maHopDong;
//
//    @Column(name = "MaPhieuPhat")
//    private Integer maPhieuPhat;
//
//    @Column(name = "MaSoSuaChua")
//    private Integer maSoSuaChua;
//
//    @Column(name = "MaSoDienNuoc")
//    private Integer maSoDienNuoc;

    @ManyToOne
    @JoinColumn(name = "MaHopDong")
    private Hopdong hopdong;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien")
    private Sinhvien sinhvien;

    @ManyToOne
    @JoinColumn(name = "MaPhieuPhat")
    private Phieuphat phieuphat;

    @ManyToOne
    @JoinColumn(name = "MaSoSuaChua")
    private Sosuachua sosuachua;

    @ManyToOne
    @JoinColumn(name = "MaSoDienNuoc")
    private Sodiennuoc sodiennuoc;


}
