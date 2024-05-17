package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Thietbi;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoSuaChuaDTO {
    private String tinhTrang;

    private LocalDateTime ngayDiSua;

    private LocalDateTime ngayNhanVe;

    @NotNull(message = "Tổng tiền không bỏ trống")
    private Float phiSuaChua;

    @NotNull(message = "Tổng tiền khoong bỏ trống")
    private Float tongTien;

    private Float trangThai;

    @NotNull(message = "Số phòng không được bỏ trống")
    private Integer soPhong;

    @NotNull(message = "Mã thiết bị khoogn được bỏ trống")
    private Integer maThietBi;


}
