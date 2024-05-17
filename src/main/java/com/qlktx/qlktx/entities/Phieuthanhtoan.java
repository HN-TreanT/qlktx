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

    @Column(name = "noi_dung_thu")
    private String noiDungThu;

    @Column(name = "ngay_thu")
    private LocalDateTime ngayThu;

    @Column(name = "so_tien")
    private Float soTien;

    @ManyToOne
    @JoinColumn(name = "ma_hop_dong")
    private Hopdong hopdong;

    @ManyToOne
    @JoinColumn(name = "so_phong")
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "ma_sinh_vien")
    private Sinhvien sinhvien;

    @ManyToOne
    @JoinColumn(name = "ma_phieu_phat")
    private Phieuphat phieuphat;

    @ManyToOne
    @JoinColumn(name = "ma_so_sua_chua")
    private Sosuachua sosuachua;

    @ManyToOne
    @JoinColumn(name = "ma_so_dien_nuoc")
    private Sodiennuoc sodiennuoc;


}
