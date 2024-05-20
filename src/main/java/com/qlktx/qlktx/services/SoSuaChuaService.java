package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.SoSuaChuaDTO;
import com.qlktx.qlktx.dto.ThietBiDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SoSuaChuaService {
    ResponseEntity<Object> list(Pageable pageable, Integer soPhong);
    ResponseEntity<Object> edit(Integer id, SoSuaChuaDTO dto);
    ResponseEntity<Object> create(SoSuaChuaDTO dto);
    ResponseEntity<Object> delete(Integer id);
    ResponseEntity<Object> detail(Integer id);
}
