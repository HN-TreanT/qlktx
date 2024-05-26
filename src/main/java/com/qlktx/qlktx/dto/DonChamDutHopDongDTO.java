package com.qlktx.qlktx.dto;

import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.entities.Sinhvien;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonChamDutHopDongDTO {

    @NotNull(message = "Ngày làm đơn không được bỏ trống")
    private LocalDateTime ngayLamDon;

    @NotBlank(message = "Lý do không được bỏ trống")
    private String lydo;

    private Integer soPhong;

    @NotNull(message = "Sinh viên không được bỏ trống")
    private Integer maSinhVien;
}
