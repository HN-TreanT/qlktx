package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Nguoidung;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sinhvien;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class SinhVienDTO {
        private  Integer maSinhVien;

        private String hoTenSinhVien;

        private java.sql.Date ngaySinh;

        private String gioiTinh;

        private String cccd;

        private String lop;

        private String khoa;

        private Integer khoaHoc;

        private String sdt;

        private String email;

        private String diaChiThuongTru;

        private Integer soPhong;

    }
