package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sodiennuoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sodiennuoc {
    @Id
    @Column(name = "MaSoDienNuoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSoDienNuoc;

    @Column(name = "DonGiaDien")
    private Float donGiaDien;

    @Column(name = "DonGiaNuoc")
    private Float donGiaNuoc;

    @Column(name = "ChiSoDien")
    private Integer chiSoDien;

    @Column(name = "ChiSoNuoc")
    private Integer chiSoNuoc;

    @Column(name = "Thang")
    private LocalDateTime thang;

//    @Column(name = "SoPhong")
//    private Integer soPhong;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

}
