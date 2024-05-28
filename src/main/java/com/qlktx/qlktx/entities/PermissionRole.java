package com.qlktx.qlktx.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permisstion_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "id_permission", nullable = true)
//    private Permission permission;
//
//    @ManyToOne
//    @JoinColumn(name = "id_nhomnguoidung", nullable = true)
//    private Nhomnguoidung nhomnguoidung;

    @Column(name = "id_permission", nullable = false)
    private Integer id_permission;

    @Column(name = "id_nhomnguoidung", nullable = false)
    private Integer id_nhomnguoidung;

    @Column(name = "action", nullable = false)
    private String action;
}
