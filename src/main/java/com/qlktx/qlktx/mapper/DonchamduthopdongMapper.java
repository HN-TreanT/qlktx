package com.qlktx.qlktx.mapper;

import com.qlktx.qlktx.dto.DonChamDutHopDongDTO;
import com.qlktx.qlktx.entities.Donchamduthopdong;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DonchamduthopdongMapper {
    Donchamduthopdong toEntity(DonChamDutHopDongDTO dto);
    DonChamDutHopDongDTO toDTO(Donchamduthopdong donchamduthopdong);
}
