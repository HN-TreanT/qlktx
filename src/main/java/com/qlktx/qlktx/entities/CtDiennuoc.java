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

    @Column(name = "TenTruongPhong", nullable = true)
    private String tenTruongPhong;

    @Column(name = "ChiSoDien", nullable = true)
    private Integer chiSoDien;

    @Column(name = "ChiSoNuoc", nullable = true)
    private Integer chiSoNuoc;

    @ManyToOne
    @JoinColumn(name = "SoPhong", nullable = true)
    private Phong phong;

    @ManyToOne
    @JoinColumn(name = "MaSoDienNuoc", nullable = true)
    private Sodiennuoc sodiennuoc;

}
