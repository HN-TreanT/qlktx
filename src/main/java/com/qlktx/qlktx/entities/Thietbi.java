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

    @Column(name = "TenThietBi")
    private String tenThietBi;

    @Column(name = "Soluong")
    private Integer soluong;

    @Column(name = "DonViTinh")
    private String donViTinh;

    @Column(name = "GiaSuaChua")
    private Float giaSuaChua;

//    @Column(name = "SoPhong")
//    private Integer soPhong;

    @ManyToOne
    @JoinColumn(name = "SoPhong")
    private Phong phong;

}
