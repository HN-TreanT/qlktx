package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sinhvien;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonDoiPhongDTO {

    @NotNull(message = "Ngày làm đơn không bỏ trống")
    private LocalDateTime ngayLamDon;

    private String lyDo;

    @NotNull(message = "Mã sinh viên không được bỏ trống")
    private Integer maSinhVien;

    @NotNull(message = "Mã phòng không được bỏ trống")
    private Integer maPhong;

}
