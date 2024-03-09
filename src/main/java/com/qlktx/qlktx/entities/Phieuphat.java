package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "phieuphat", indexes = {
        @Index(name = "SoPhong", columnList = "SoPhong"),
        @Index(name = "MaThietBi", columnList = "MaThietBi"),
        @Index(name = "ID_NV", columnList = "ID_NV")
})
@Entity
public class Phieuphat {
    @Id
    @Column(name = "MaPhieuPhat", nullable = false)
    private Integer id;

    @Column(name = "NgayLapPhieu")
    private LocalDate ngayLapPhieu;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "LyDo")
    private String lyDo;

    @Column(name = "PhiPhat", precision = 10, scale = 2)
    private BigDecimal phiPhat;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong soPhong;

    @ManyToOne
    @JoinColumn(name = "ID_NV")
    private Nguoidung idNv;

    @ManyToOne
    @JoinColumn(name = "MaThietBi")
    private Thietbi maThietBi;

    public Thietbi getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(Thietbi maThietBi) {
        this.maThietBi = maThietBi;
    }

    public Nguoidung getIdNv() {
        return idNv;
    }

    public void setIdNv(Nguoidung idNv) {
        this.idNv = idNv;
    }

    public Phong getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(Phong soPhong) {
        this.soPhong = soPhong;
    }

    public BigDecimal getPhiPhat() {
        return phiPhat;
    }

    public void setPhiPhat(BigDecimal phiPhat) {
        this.phiPhat = phiPhat;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public LocalDate getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(LocalDate ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}