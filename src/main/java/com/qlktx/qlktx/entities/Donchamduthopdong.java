package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "donchamduthopdong")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donchamduthopdong {
    @Id
    @Column(name = "MaDonChamDut")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDonChamDut;

    @Column(name = "NgayLamDon")
    private LocalDateTime ngayLamDon;

    @Column(name = "Lydo")
    private String lydo;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien")
    private Sinhvien sinhvien;

}
