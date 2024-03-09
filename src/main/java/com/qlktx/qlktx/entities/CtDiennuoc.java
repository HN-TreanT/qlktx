package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

@Table(name = "ct_diennuoc", indexes = {
        @Index(name = "SoPhong", columnList = "SoPhong")
})
@Entity
public class CtDiennuoc {
    @EmbeddedId
    private CtDiennuocId id;

    @Column(name = "TenTruongPhong")
    private String tenTruongPhong;

    @Column(name = "ChiSoDien")
    private Integer chiSoDien;

    @Column(name = "ChiSoNuoc")
    private Integer chiSoNuoc;

    public Integer getChiSoNuoc() {
        return chiSoNuoc;
    }

    public void setChiSoNuoc(Integer chiSoNuoc) {
        this.chiSoNuoc = chiSoNuoc;
    }

    public Integer getChiSoDien() {
        return chiSoDien;
    }

    public void setChiSoDien(Integer chiSoDien) {
        this.chiSoDien = chiSoDien;
    }

    public String getTenTruongPhong() {
        return tenTruongPhong;
    }

    public void setTenTruongPhong(String tenTruongPhong) {
        this.tenTruongPhong = tenTruongPhong;
    }

    public CtDiennuocId getId() {
        return id;
    }

    public void setId(CtDiennuocId id) {
        this.id = id;
    }
}