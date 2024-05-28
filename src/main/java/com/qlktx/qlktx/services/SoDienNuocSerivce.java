package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.SoDienNuocDTO;
import com.qlktx.qlktx.dto.SoSuaChuaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SoDienNuocSerivce {
    ResponseEntity<Object> list(Pageable pageable, Integer soPhong);
    ResponseEntity<Object> edit(Integer id, SoDienNuocDTO dto);
    ResponseEntity<Object> create(SoDienNuocDTO dto);
    ResponseEntity<Object> delete(Integer id);
    ResponseEntity<Object> detail(Integer id);
    ResponseEntity<Object> thongke();
}
