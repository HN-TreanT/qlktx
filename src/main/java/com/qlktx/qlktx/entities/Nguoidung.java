package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

@Table(name = "nguoidung", indexes = {
        @Index(name = "ID_Nhom", columnList = "ID_Nhom")
})
@Entity
public class Nguoidung {
    @Id
    @Column(name = "ID_NV", nullable = false)
    private Integer id;

    @Column(name = "Ten_NV")
    private String tenNv;

    @Column(name = "SDT", length = 20)
    private String sdt;

    @Column(name = "CCCD", length = 20)
    private String cccd;

    @Column(name = "TenDangNhap")
    private String tenDangNhap;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "ChucVu")
    private String chucVu;

    @ManyToOne
    @JoinColumn(name = "ID_Nhom")
    private Nhomnguoidung idNhom;

    public Nhomnguoidung getIdNhom() {
        return idNhom;
    }

    public void setIdNhom(Nhomnguoidung idNhom) {
        this.idNhom = idNhom;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}