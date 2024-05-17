package com.qlktx.qlktx.mapper;

import com.qlktx.qlktx.dto.PhieuPhatDTO;
import com.qlktx.qlktx.entities.Phieuphat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuPhatMapper {
    PhieuPhatDTO toDTO(Phieuphat phieuphat);
    Phieuphat toEntity(PhieuPhatDTO phieuPhatDTO);
}
