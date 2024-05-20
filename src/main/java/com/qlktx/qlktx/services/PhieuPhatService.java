package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.PhieuPhatDTO;
import com.qlktx.qlktx.dto.PhieuThanhToanDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface PhieuPhatService {
    ResponseEntity<Object> list(Pageable pageable, Integer maPhong, LocalDateTime timeStart, LocalDateTime timeEnd);
    ResponseEntity<Object> edit(Integer id, PhieuPhatDTO dto);
    ResponseEntity<Object> create(PhieuPhatDTO dto);
    ResponseEntity<Object> delete(Integer id);
    ResponseEntity<Object> detail(Integer id);
}
