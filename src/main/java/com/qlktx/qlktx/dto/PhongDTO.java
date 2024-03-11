package com.qlktx.qlktx.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiPhongDTO {
    @NotBlank(message = "tên loại phòng k bỏ trống")
    private  String tenLoaiPhong;

    @NotBlank(message = "số lượng người k đc trống")
    private Integer soLuongNguoi;

    private String ghichu;
}
