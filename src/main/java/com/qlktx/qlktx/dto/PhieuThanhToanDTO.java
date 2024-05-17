package com.qlktx.qlktx.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhieuThanhToanDTO {

    @NotBlank(message = "Nội dung thu không được bỏ trống")
    private String noiDungThu;

    @NotNull(message = "Ngày thu không được bỏ trống")
    private LocalDateTime ngayThu;

    @NotNull(message = "Số tiền thu")
    private Float soTien;

    private Integer maHopDong;

    @NotNull(message = "Mã phòng không được bỏ trống")
    private Integer maPhong;

    private Integer maSinhVien;

    private Integer maPhieuPhat;

    private Integer maSoSuaChua;

    private Integer maSoDienNuoc;

}
