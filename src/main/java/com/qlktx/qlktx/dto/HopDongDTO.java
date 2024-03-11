package com.qlktx.qlktx.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class PhongDTO {
    @NotBlank(message = "Tên phòng không được bỏ trống")
    private String tenPhong;

    @NotBlank(message = "Số tầng không được bỏ trống")
    private Integer soTang;

    @NotBlank(message = "Số phòng không được bỏ trống")
    private Integer soPhong;

    @NotBlank(message = "Số nhà không được bỏ trống")
    private String soNha;

    @NotBlank(message = "Trạng thái không được bỏ trống")
    private String trangThai;

    @NotBlank(message = "Loại phòng không được bỏ trống")
    private Integer maLoaiPhong;

    private Integer maTruongPhong;

}
