package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.entities.Sinhvien;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class PhongDTO {
    @NotBlank(message = "Tên phòng không được bỏ trống")
    private String tenPhong;

    @NotNull(message = "Số tầng không được bỏ trống")
    private Integer soTang ;

    private Integer soNguoiO;

    @NotBlank(message = "Số nhà không được bỏ trống")
    private String soNha;

    @NotNull(message = "Trạng thái không được bỏ trống")
    private Integer trangThai;

    private  Integer maLoaiPhong;

    private  Integer maTruongPhong;
}
