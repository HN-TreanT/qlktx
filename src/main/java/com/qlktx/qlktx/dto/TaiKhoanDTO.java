package com.qlktx.qlktx.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoanDTO {
    @NotBlank(message = "user không được bỏ trống")
    private String username;

    @NotBlank(message = "password không được bỏ trống")
    private String password;
}
