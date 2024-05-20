package com.qlktx.qlktx.mapper;

import com.qlktx.qlktx.dto.PhieuThanhToanDTO;
import com.qlktx.qlktx.entities.Phieuthanhtoan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuThanhToanMapper {
    Phieuthanhtoan toEntity(PhieuThanhToanDTO phieuThanhToanDTO);
    PhieuThanhToanDTO toDTO(Phieuthanhtoan phieuthanhtoan);
}
