package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "dondangky", indexes = {
        @Index(name = "MaSinhVien", columnList = "MaSinhVien")
})
@Entity
public class Dondangky {
    @Id
    @Column(name = "MaDonDangKy", nullable = false)
    private Integer id;

    @Column(name = "NgayLamDon")
    private LocalDate ngayLamDon;

    @Column(name = "DoiTuongUuTien")
    private String doiTuongUuTien;

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

    public String getDoiTuongUuTien() {
        return doiTuongUuTien;
    }

    public void setDoiTuongUuTien(String doiTuongUuTien) {
        this.doiTuongUuTien = doiTuongUuTien;
    }

    public LocalDate getNgayLamDon() {
        return ngayLamDon;
    }

    public void setNgayLamDon(LocalDate ngayLamDon) {
        this.ngayLamDon = ngayLamDon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}