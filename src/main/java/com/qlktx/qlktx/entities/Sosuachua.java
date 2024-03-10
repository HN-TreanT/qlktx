package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private java.sql.Date ngayDiSua;

    @Column(name = "NgayNhanVe")
    private java.sql.Date ngayNhanVe;

    @Column(name = "PhiSuaChua")
    private Float phiSuaChua;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "MaThietBi")
    private Thietbi thietbi;


}
