package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loaiphong")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loaiphong {
    @Id
    @Column(name = "MaLoaiPhong", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLoaiPhong;

    @Column(name = "TenLoaiPhong", nullable = true)
    private String tenLoaiPhong;

    @Column(name = "SoLuongNguoi", nullable = true)
    private Integer soLuongNguoi;

    @Column(name = "GhiChu", nullable = true)
    private String ghiChu;

//    @OneToMany(mappedBy = "loaiphong", cascade = {CascadeType.ALL})
//    private List<Phong> phongs  = new ArrayList<>();


}
