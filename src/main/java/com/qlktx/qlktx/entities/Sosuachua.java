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

    @Column(name = "TinhTrang", nullable = true)
    private String tinhTrang;

    @Column(name = "NgayDiSua", nullable = true)
    private LocalDateTime ngayDiSua;

    @Column(name = "NgayNhanVe", nullable = true)
    private LocalDateTime ngayNhanVe;

    @Column(name = "PhiSuaChua", nullable = true)
    private Float phiSuaChua;

    @Column(name = "tong_tien", nullable = true)
    private Float tongTien;

    @Column(name = "trang_thai", nullable = true)
    private Float trangThai;

    @ManyToOne
    @JoinColumn(name = "SoPhong", nullable = true)
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "ma_thiet_bi", nullable = true)
    private Thietbi thietbi;

    //FK
    @Column(name = "ma_phieu_thanh_toan")
    private Integer maPhieuThanhToan;

}
