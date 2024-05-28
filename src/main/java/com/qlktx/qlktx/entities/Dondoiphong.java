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

    @Column(name = "NgayLamDon", nullable = true)
    private LocalDateTime ngayLamDon;

    @Column(name = "LyDo", nullable = true)
    private String lyDo;

    @Column(name = "TrangThai", nullable = true)
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "MaSinhVien", nullable = true)
    private Sinhvien sinhvien;

    @ManyToOne
    @JoinColumn(name = "SoPhong", nullable = true)
    private Phong phong;

}
