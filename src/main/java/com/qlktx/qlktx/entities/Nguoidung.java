package com.qlktx.qlktx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "nguoidung")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nguoidung implements UserDetails {
    @Id
    @Column(name = "ID_NV", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNv;

    @Column(name = "Ten_NV", nullable = true)
    private String tenNv;

    @Column(name = "SDT", nullable = true)
    private String sdt;

    @Column(name = "CCCD", nullable = true)
    private String cccd;

    @Column(name = "TenDangNhap", unique = true)
    private String tenDangNhap;

    @Column(name = "MatKhau", nullable = true)
    private String matKhau;

    @Column(name = "ChucVu", nullable = true)
    private String chucVu;

    @ManyToOne
    @JoinColumn(name = "ID_Nhom", nullable = true)
    private Nhomnguoidung nhomnguoidung;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(nhomnguoidung.getQuyen()));
    }

    @Override
    public String getPassword() {
        return matKhau;
    }

    @Override
    public String getUsername() {
        return tenDangNhap;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
