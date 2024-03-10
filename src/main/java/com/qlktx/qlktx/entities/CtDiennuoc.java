package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ct_diennuoc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CtDiennuoc {
    @Id
    @Column(name = "MaCTDienNuoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MaCTDienNuoc;

    @Column(name = "TenTruongPhong")
    private String tenTruongPhong;

    @Column(name = "ChiSoDien")
    private Integer chiSoDien;

    @Column(name = "ChiSoNuoc")
    private Integer chiSoNuoc;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "MaSoDienNuoc")
    private Sodiennuoc sodiennuoc;

}
