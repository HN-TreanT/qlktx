package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "bienbanbangiao", indexes = {
        @Index(name = "MaSinhVien", columnList = "MaSinhVien")
})
@Entity
public class Bienbanbangiao {
    @Id
    @Column(name = "MaBienBan", nullable = false)
    private Integer id;

    @Column(name = "NgayBanGiao")
    private LocalDate ngayBanGiao;

    @Column(name = "HoTenNguoiBanGiao")
    private String hoTenNguoiBanGiao;

    @Column(name = "HoTenSinhVien")
    private String hoTenSinhVien;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien")
    private Sinhvien maSinhVien;

    public Sinhvien getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(Sinhvien maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTenSinhVien() {
        return hoTenSinhVien;
    }

    public void setHoTenSinhVien(String hoTenSinhVien) {
        this.hoTenSinhVien = hoTenSinhVien;
    }

    public String getHoTenNguoiBanGiao() {
        return hoTenNguoiBanGiao;
    }

    public void setHoTenNguoiBanGiao(String hoTenNguoiBanGiao) {
        this.hoTenNguoiBanGiao = hoTenNguoiBanGiao;
    }

    public LocalDate getNgayBanGiao() {
        return ngayBanGiao;
    }

    public void setNgayBanGiao(LocalDate ngayBanGiao) {
        this.ngayBanGiao = ngayBanGiao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}