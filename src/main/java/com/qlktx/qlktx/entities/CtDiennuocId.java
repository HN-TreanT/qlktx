package com.qlktx.qlktx.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CtDiennuocId implements Serializable {
    private static final long serialVersionUID = 1967628470572588637L;
    @Column(name = "MaSoDienNuoc", nullable = false)
    private Integer maSoDienNuoc;
    @Column(name = "SoPhong", nullable = false)
    private Integer soPhong;

    public Integer getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(Integer soPhong) {
        this.soPhong = soPhong;
    }

    public Integer getMaSoDienNuoc() {
        return maSoDienNuoc;
    }

    public void setMaSoDienNuoc(Integer maSoDienNuoc) {
        this.maSoDienNuoc = maSoDienNuoc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSoDienNuoc, soPhong);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CtDiennuocId entity = (CtDiennuocId) o;
        return Objects.equals(this.maSoDienNuoc, entity.maSoDienNuoc) &&
                Objects.equals(this.soPhong, entity.soPhong);
    }
}