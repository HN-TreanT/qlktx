package com.qlktx.qlktx.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungDTO {
    @NotBlank(message = "Không được bỏ trống")
    private String tenNv;
//    @NotBlank(message = "Không được bỏ trống")
//    @Size(min = 2, max = 11, message = "Cao nhất là 11")
    private String sdt;
    private String cccd;
    @NotBlank(message = "Không được bỏ trống")
    private String tenDangNhap;
    @NotBlank(message = "Không được bỏ trống")
    private String matKhau;
//    @NotBlank(message = "Không được bỏ trống")
    private String chucVu;
    @NotNull(message = "Không được bỏ trống")
    private Integer id_nhom;
}
