package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Nguoidung;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sinhvien;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class SinhVienDTO {

        @NotBlank(message = "Tên sinh viên không đượcn")
        private String hoTenSinhVien;

        @NotNull(message = "Không bỏ trống")
        private LocalDateTime ngaySinh;

        @NotNull(message = "Giới tính không bỏ trống")
        private String gioiTinh;

        private String cccd;

        private String lop;

        private String khoa;

        private String khoaHoc;

        private String sdt;


        @NotBlank(message = "Khóa học không bỏ trống")
        @Email(message = "Đây không phải email")
        private String email;

        @NotNull(message = "Địa chỉ không bỏ trống")
        private String diaChiThuongTru;


        private Integer soPhong;

    }
