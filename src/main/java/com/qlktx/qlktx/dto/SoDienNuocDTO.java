package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Phong;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoDienNuocDTO {

    @NotNull(message = "Đơn giá điện không bỏ trống")
    private Float donGiaDien;

    @NotNull(message = "Đơn giá nước không bỏ trống")
    private Float donGiaNuoc;

    @NotNull(message = "Chỉ số điện không bỏ trống")
    private Integer chiSoDien;

    @NotNull(message = "Chỉ số nước không bỏ trống")
    private Integer chiSoNuoc;

    @NotNull(message = "tháng không bỏ trống")
    private LocalDateTime thang;

    @NotNull(message = "Mã phiếu thanh toán không được bỏ trống")
    private Integer maPhieuThanhToan;

    private Float tongTien;

    private Float trangThai;

    @NotNull(message = "phòng không được bỏ trống")
    private Integer soPhong;

}
