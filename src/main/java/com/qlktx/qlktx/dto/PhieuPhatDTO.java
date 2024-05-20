package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Nguoidung;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Thietbi;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhieuPhatDTO {

    @NotNull(message = "Ngày lập phiếu không được bỏ trống")
    private LocalDateTime ngayLapPhieu;

    private Integer soLuong;

    @NotBlank(message = "Lý do không được bỏ trống")
    private String lyDo;

    @NotNull(message = "Mã phiếu thanh toán không được bỏ trống")
    private Integer maPhieuThanhToan;

    @NotNull(message = "phí phạt không được bỏ trống")
    private Float phiPhat;

    @NotNull(message = "người phạt không được bỏ trống")
    private Integer idNV;

    @NotNull(message = "Mã phòng không được bỏ trống")
    private Integer maPhong;

    private Integer maThietbi;
}
