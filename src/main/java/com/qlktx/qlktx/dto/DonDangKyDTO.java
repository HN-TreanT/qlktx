package com.qlktx.qlktx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class DonDangKyDTO {

        private  Integer maSinhVien;

        private String doiTuongUuTien;

        private String hoTenSinhVien;

    private String trangThai;

    private Integer soThang;

    private String loaiPhong;

        private java.sql.Date ngayLamDon;

    }
