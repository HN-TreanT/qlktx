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

    @Column(name = "NgayLapPhieu")
    private LocalDateTime ngayLapPhieu;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "LyDo")
    private String lyDo;

    @Column(name = "PhiPhat")
    private Float phiPhat;

    @ManyToOne
    @JoinColumn(name = "ID_NV")
    private Nguoidung nguoidung;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "MaThietBi")
    private Thietbi thietbi;

    //    @OneToMany(mappedBy = "loaiphong", cascade = {CascadeType.ALL})
//    private List<Phong> phongs  = new ArrayList<>();
    @OneToMany(mappedBy = "phieuphat", cascade = {CascadeType.ALL})
    private List<Phieuthanhtoan> phieuthanhtoans = new ArrayList<>();

}
