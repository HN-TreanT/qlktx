package com.qlktx.qlktx.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "sodiennuoc")
@Entity
public class Sodiennuoc {
    @Id
    @Column(name = "MaSoDienNuoc", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}