package com.qlktx.qlktx.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "loaiphong")
@Entity
public class Loaiphong {
    @Id
    @Column(name = "MaLoaiPhong", nullable = false)
    private Integer id;

    @Column(name = "TenLoaiPhong")
    private String tenLoaiPhong;

    @Column(name = "SoLuongNguoi")
    private Integer soLuongNguoi;

    @Column(name = "GhiChu")
    private String ghiChu;

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Integer getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(Integer soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}