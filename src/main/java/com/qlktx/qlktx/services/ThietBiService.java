package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.DonDoiPhongDTO;
import com.qlktx.qlktx.dto.ThietBiDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ThietBiService {
    ResponseEntity<Object> list(Pageable pageable, String tenThietBi);
    ResponseEntity<Object> edit(Integer id, ThietBiDTO dto);
    ResponseEntity<Object> create(ThietBiDTO dto);
    ResponseEntity<Object> delete(Integer id);
    ResponseEntity<Object> detail(Integer id);
}
