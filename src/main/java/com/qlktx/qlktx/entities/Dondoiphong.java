package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "dondoiphong", indexes = {
        @Index(name = "SoPhong", columnList = "SoPhong"),
        @Index(name = "MaSinhVien", columnList = "MaSinhVien")
})
@Entity
public class Dondoiphong {
    @Id
    @Column(name = "MaDonDoiPhong", nullable = false)
    private Integer id;

    @Column(name = "NgayLamDon")
    private LocalDate ngayLamDon;

    @Column(name = "LyDo")
    private String lyDo;

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

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
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