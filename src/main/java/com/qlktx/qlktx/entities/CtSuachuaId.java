package com.qlktx.qlktx.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CtSuachuaId implements Serializable {
    private static final long serialVersionUID = -8215427057241721513L;
    @Column(name = "MaSoSuaChua", nullable = false)
    private Integer maSoSuaChua;
    @Column(name = "MaThietBi", nullable = false)
    private Integer maThietBi;

    public Integer getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(Integer maThietBi) {
        this.maThietBi = maThietBi;
    }

    public Integer getMaSoSuaChua() {
        return maSoSuaChua;
    }

    public void setMaSoSuaChua(Integer maSoSuaChua) {
        this.maSoSuaChua = maSoSuaChua;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maThietBi, maSoSuaChua);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CtSuachuaId entity = (CtSuachuaId) o;
        return Objects.equals(this.maThietBi, entity.maThietBi) &&
                Objects.equals(this.maSoSuaChua, entity.maSoSuaChua);
    }
}