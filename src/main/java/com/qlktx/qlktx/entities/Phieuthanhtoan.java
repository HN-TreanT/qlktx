package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "phieuthanhtoan", indexes = {
        @Index(name = "MaPhieuPhat", columnList = "MaPhieuPhat"),
        @Index(name = "MaSoSuaChua", columnList = "MaSoSuaChua"),
        @Index(name = "SoPhong", columnList = "SoPhong"),
        @Index(name = "MaSoDienNuoc", columnList = "MaSoDienNuoc"),
        @Index(name = "MaHopDong", columnList = "MaHopDong"),
        @Index(name = "MaSinhVien", columnList = "MaSinhVien")
})
@Entity
public class Phieuthanhtoan {
    @Id
    @Column(name = "MaPhieuThanhToa", nullable = false)
    private Integer id;

    @Column(name = "NoiDungThu")
    private String noiDungThu;

    @Column(name = "NgayThu")
    private LocalDate ngayThu;

    @Column(name = "SoTien", precision = 10, scale = 2)
    private BigDecimal soTien;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong soPhong;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien")
    private Sinhvien maSinhVien;

    @ManyToOne
    @JoinColumn(name = "MaHopDong")
    private Hopdong maHopDong;

    @ManyToOne
    @JoinColumn(name = "MaPhieuPhat")
    private Phieuphat maPhieuPhat;

    @ManyToOne
    @JoinColumn(name = "MaSoSuaChua")
    private Sosuachua maSoSuaChua;

    @ManyToOne
    @JoinColumn(name = "MaSoDienNuoc")
    private Sodiennuoc maSoDienNuoc;

    public Sodiennuoc getMaSoDienNuoc() {
        return maSoDienNuoc;
    }

    public void setMaSoDienNuoc(Sodiennuoc maSoDienNuoc) {
        this.maSoDienNuoc = maSoDienNuoc;
    }

    public Sosuachua getMaSoSuaChua() {
        return maSoSuaChua;
    }

    public void setMaSoSuaChua(Sosuachua maSoSuaChua) {
        this.maSoSuaChua = maSoSuaChua;
    }

    public Phieuphat getMaPhieuPhat() {
        return maPhieuPhat;
    }

    public void setMaPhieuPhat(Phieuphat maPhieuPhat) {
        this.maPhieuPhat = maPhieuPhat;
    }

    public Hopdong getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(Hopdong maHopDong) {
        this.maHopDong = maHopDong;
    }

    public Sinhvien getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(Sinhvien maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public Phong getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(Phong soPhong) {
        this.soPhong = soPhong;
    }

    public BigDecimal getSoTien() {
        return soTien;
    }

    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }

    public LocalDate getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(LocalDate ngayThu) {
        this.ngayThu = ngayThu;
    }

    public String getNoiDungThu() {
        return noiDungThu;
    }

    public void setNoiDungThu(String noiDungThu) {
        this.noiDungThu = noiDungThu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}