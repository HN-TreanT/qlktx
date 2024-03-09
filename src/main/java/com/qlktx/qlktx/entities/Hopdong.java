package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "hopdong", indexes = {
        @Index(name = "SoPhong", columnList = "SoPhong"),
        @Index(name = "MaSinhVien", columnList = "MaSinhVien")
})
@Entity
public class Hopdong {
    @Id
    @Column(name = "MaHopDong", nullable = false)
    private Integer id;

    @Column(name = "NgayHopDong")
    private LocalDate ngayHopDong;

    @Column(name = "TenNguoiLam")
    private String tenNguoiLam;

    @Column(name = "SDTNguoiLam", length = 20)
    private String sDTNguoiLam;

    @Column(name = "ThoiGianChoThue")
    private LocalDate thoiGianChoThue;

    @Column(name = "ThoiGianHetHan")
    private LocalDate thoiGianHetHan;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien")
    private Sinhvien maSinhVien;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong soPhong;

    public Phong getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(Phong soPhong) {
        this.soPhong = soPhong;
    }

    public Sinhvien getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(Sinhvien maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public LocalDate getThoiGianHetHan() {
        return thoiGianHetHan;
    }

    public void setThoiGianHetHan(LocalDate thoiGianHetHan) {
        this.thoiGianHetHan = thoiGianHetHan;
    }

    public LocalDate getThoiGianChoThue() {
        return thoiGianChoThue;
    }

    public void setThoiGianChoThue(LocalDate thoiGianChoThue) {
        this.thoiGianChoThue = thoiGianChoThue;
    }

    public String getSDTNguoiLam() {
        return sDTNguoiLam;
    }

    public void setSDTNguoiLam(String sDTNguoiLam) {
        this.sDTNguoiLam = sDTNguoiLam;
    }

    public String getTenNguoiLam() {
        return tenNguoiLam;
    }

    public void setTenNguoiLam(String tenNguoiLam) {
        this.tenNguoiLam = tenNguoiLam;
    }

    public LocalDate getNgayHopDong() {
        return ngayHopDong;
    }

    public void setNgayHopDong(LocalDate ngayHopDong) {
        this.ngayHopDong = ngayHopDong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}