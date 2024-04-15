package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ct_suachua")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CtSuachua {
    @Id
    @Column(name = "MaCTSuaChua")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maCtSuaChua;

    @Column(name = "TinhTrang")
    private String tinhTrang;

    @Column(name = "NgayDiSua")
    private LocalDateTime ngayDiSua;

    @Column(name = "NgayNhanVe")
    private LocalDateTime ngayNhanVe;

    @Column(name = "ChiPhiSua")
    private Float chiPhiSua;

    @ManyToOne
    @JoinColumn(name = "MaThietBi")
    private Thietbi thietbi;

    @ManyToOne
    @JoinColumn(name = "MaSoSuaChua")
    private Sosuachua sosuachua;

}
