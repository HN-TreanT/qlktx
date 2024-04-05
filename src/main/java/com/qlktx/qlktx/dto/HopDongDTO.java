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

        private Integer maSinhVien;

        private Integer tienCoc;

        private Integer maNV;

        private Integer soPhong;
    }
