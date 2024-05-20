package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Sinhvien;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BienBanBanGiaoDTO {

    @NotNull(message = "Ngày bàn giao không được bỏ trống")
    private LocalDateTime ngayBanGiao;

    @NotBlank(message = "Họ tên người bàn giao không được bỏ trống")
    private String hoTenNguoiBanGiao;

    @NotBlank(message = "Họ tên sinh viên giao không được bỏ trống")
    private String hoTenSinhVien;

    @NotNull(message = "Mã sinh viên không được bỏ trống")
    private Integer maSinhVien;

}
