package com.qlktx.qlktx.mapper;

import com.qlktx.qlktx.dto.SoDienNuocDTO;
import com.qlktx.qlktx.entities.Sodiennuoc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SoDienNuocMapper {
     Sodiennuoc toEntity(SoDienNuocDTO soDienNuocDTO);
     SoDienNuocDTO toDTO(Sodiennuoc sodiennuoc);
}
