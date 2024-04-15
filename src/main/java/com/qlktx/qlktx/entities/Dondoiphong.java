package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "dondoiphong")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dondoiphong {
    @Id
    @Column(name = "MaDonDoiPhong")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDonDoiPhong;

    @Column(name = "NgayLamDon")
    private LocalDateTime ngayLamDon;

    @Column(name = "LyDo")
    private String lyDo;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien")
    private Sinhvien sinhvien;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

}
