package com.qlktx.qlktx.mapper;

import com.qlktx.qlktx.dto.SoSuaChuaDTO;
import com.qlktx.qlktx.entities.Sosuachua;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SoSuaChuaMapper {
    SoSuaChuaDTO toDTO(Sosuachua sosuachua);
    Sosuachua toEnity(SoSuaChuaDTO soSuaChuaDTO);
}
