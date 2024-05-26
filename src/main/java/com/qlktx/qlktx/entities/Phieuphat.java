package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "phieuphat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phieuphat {
    @Id
    @Column(name = "MaPhieuPhat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maPhieuPhat;

    @Column(name = "NgayLapPhieu", nullable = true)
    private LocalDateTime ngayLapPhieu;

    @Column(name = "SoLuong", nullable = true)
    private Integer soLuong;

    @Column(name = "LyDo", nullable = true)
    private String lyDo;

    @Column(name = "PhiPhat", nullable = true)
    private Float phiPhat;

    @ManyToOne
    @JoinColumn(name = "ID_NV", nullable = true)
    private Nguoidung nguoidung;

    @ManyToOne
    @JoinColumn(name = "SoPhong", nullable = true)
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "MaThietBi", nullable = true)
    private Thietbi thietbi;

    //FK
    @Column(name = "ma_phieu_thanh_toan")
    private Integer maPhieuThanhToan;

    @Column(name = "trang_thai")
    private Integer trangThai;


}
