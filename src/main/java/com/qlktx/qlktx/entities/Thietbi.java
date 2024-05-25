package com.qlktx.qlktx.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "thietbi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Thietbi {
    @Id
    @Column(name = "MaThietBi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maThietBi;

    @Column(name = "TenThietBi", nullable = true)
    private String tenThietBi;

    @Column(name = "Soluong", nullable = true)
    private Integer soluong;

    @Column(name = "DonViTinh", nullable = true)
    private String donViTinh;

    @Column(name = "GiaSuaChua", nullable = true)
    private Float giaSuaChua;

//    @Column(name = "SoPhong")
//    private Integer soPhong;

    @ManyToOne
    @JoinColumn(name = "SoPhong", nullable = true)
    private Phong phong;

}
