package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Phong;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThietBiDTO {

    @NotBlank(message = "Tên thiết bị không được bỏ trống")
    private String tenThietBi;

    @NotNull(message = "Số lượng không được bỏ trống")
    private Integer soluong;

    private String donViTinh;

}
