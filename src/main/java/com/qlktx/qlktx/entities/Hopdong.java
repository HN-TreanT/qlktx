package com.qlktx.qlktx.entities;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "hopdong")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hopdong {
    @Id
    @Column(name = "MaHopDong")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHopDong;

    @Column(name = "NgayHopDong", nullable = true)
    private LocalDateTime ngayHopDong;
//
//    @Column(name = "TenNguoiLam")
//    private String tenNguoiLam;
//
//    @Column(name = "SDTNguoiLam")
//    private String sdtNguoiLam;

    @Column(name = "TrangThai", nullable = true)
    private String trangThai;

    @Column(name = "ThoiGianChoThue", nullable = true)
    private LocalDateTime thoiGianChoThue;

    @Column(name = "ThoiGianHetHan", nullable = true)
    private LocalDateTime thoiGianHetHan;

    @Column(name = "TienCoc", nullable = true)
    private Integer tienCoc;


    @ManyToOne
    @JoinColumn(name = "MaSinhVien", nullable = true)
    private Sinhvien sinhvien;

    @OneToOne
    @JoinColumn(name = "MaNV", nullable = true)
    private Nguoidung nguoidung;

    @ManyToOne
    @JoinColumn(name = "SoPhong", nullable = true)
    private Phong phong;

//    @OneToMany(mappedBy = "hopdong", cascade = {CascadeType.ALL})
//    private  List<Phieuthanhtoan> phieuthanhtoans = new ArrayList<>();

}
