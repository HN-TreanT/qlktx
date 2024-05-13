package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sosuachua")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sosuachua {
    @Id
    @Column(name = "MaSoSuaChua")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSoSuaChua;

//    @Column(name = "SoPhong")
//    private Integer soPhong;
//
//    @Column(name = "MaThietBi")
//    private Integer maThietBi;

    @Column(name = "TinhTrang")
    private String tinhTrang;

    @Column(name = "NgayDiSua")
    private LocalDateTime ngayDiSua;

    @Column(name = "NgayNhanVe")
    private LocalDateTime ngayNhanVe;

    @Column(name = "PhiSuaChua")
    private Float phiSuaChua;

    @Column(name = "tong_tine")
    private Float tongTien;

    @Column(name = "trang_thai")
    private Float trangThai;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "MaThietBi")
    private Thietbi thietbi;


}
