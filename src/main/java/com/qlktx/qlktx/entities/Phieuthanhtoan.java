package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "phieuthanhtoan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phieuthanhtoan {
    @Id
    @Column(name = "ma_phieu_thanh_toan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maPhieuThanhToan;

    @Column(name = "noi_dung_thu", nullable = true)
    private String noiDungThu;

    @Column(name = "ngay_thu", nullable = true)
    private LocalDateTime ngayThu;

    @Column(name = "so_tien", nullable = true)
    private Float soTien;

    @Column(name = "trang_thai", nullable = true)
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "ma_hop_dong", nullable = true)
    private Hopdong hopdong;

    @ManyToOne
    @JoinColumn(name = "so_phong", nullable = true)
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "ma_sinh_vien", nullable = true)
    private Sinhvien sinhvien;

//    @ManyToOne
//    @JoinColumn(name = "ma_phieu_phat")
//    private Phieuphat phieuphat;
//
//    @ManyToOne
//    @JoinColumn(name = "ma_so_sua_chua")
//    private Sosuachua sosuachua;
//
//    @ManyToOne
//    @JoinColumn(name = "ma_so_dien_nuoc")
//    private Sodiennuoc sodiennuoc;


}
