package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "ct_suachua", indexes = {
        @Index(name = "MaThietBi", columnList = "MaThietBi")
})
@Entity
public class CtSuachua {
    @EmbeddedId
    private CtSuachuaId id;

    @Column(name = "TinhTrang")
    private String tinhTrang;

    @Column(name = "NgayDiSua")
    private LocalDate ngayDiSua;

    @Column(name = "NgayNhanVe")
    private LocalDate ngayNhanVe;

    @Column(name = "ChiPhiSua", precision = 10, scale = 2)
    private BigDecimal chiPhiSua;

    public BigDecimal getChiPhiSua() {
        return chiPhiSua;
    }

    public void setChiPhiSua(BigDecimal chiPhiSua) {
        this.chiPhiSua = chiPhiSua;
    }

    public LocalDate getNgayNhanVe() {
        return ngayNhanVe;
    }

    public void setNgayNhanVe(LocalDate ngayNhanVe) {
        this.ngayNhanVe = ngayNhanVe;
    }

    public LocalDate getNgayDiSua() {
        return ngayDiSua;
    }

    public void setNgayDiSua(LocalDate ngayDiSua) {
        this.ngayDiSua = ngayDiSua;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public CtSuachuaId getId() {
        return id;
    }

    public void setId(CtSuachuaId id) {
        this.id = id;
    }
}