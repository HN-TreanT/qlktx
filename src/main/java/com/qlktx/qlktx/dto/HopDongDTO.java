package com.qlktx.qlktx.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.entities.Nguoidung;
import com.qlktx.qlktx.entities.Phong;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class HopDongDTO {

        private String tenPhong;

        private String trangThai;

        private java.sql.Date ngayHopDong;

        private java.sql.Date thoiGianChoThue;

        private java.sql.Date thoiGianHetHan;

        @NotBlank(message = "Sinh viên không được bỏ trống")
        private Sinhvien maSinhVien;

        private Nguoidung maNV;

        private Phong soPhong;
    }
