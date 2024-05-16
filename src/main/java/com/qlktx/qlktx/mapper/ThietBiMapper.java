package com.qlktx.qlktx.mapper;


import com.qlktx.qlktx.dto.ThietBiDTO;
import com.qlktx.qlktx.entities.Thietbi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ThietBiMapper {
    Thietbi toEntity(ThietBiDTO thietBiDTO);
    ThietBiDTO toDTO(Thietbi thietbi);
}
