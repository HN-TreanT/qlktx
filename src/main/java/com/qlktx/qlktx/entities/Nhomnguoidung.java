package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nhomnguoidung")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nhomnguoidung {
    @Id
    @Column(name = "ID_Nhom", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNhom;

    @Column(name = "TenNhom", nullable = true)
    private String tenNhom;

    @Column(name = "Quyen", nullable = true)
    private String quyen;

}
