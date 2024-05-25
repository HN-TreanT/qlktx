package com.qlktx.qlktx.services;


import com.qlktx.qlktx.dto.PhieuThanhToanDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface PhieuThanhToanService {
    ResponseEntity<Object> list(Pageable pageable, Integer soPhong, LocalDateTime timeStart, LocalDateTime timeEnd);
    ResponseEntity<Object> getListPhieuThanhToanTungPhong(Pageable pageable, Integer soPhong, LocalDateTime timeStart, LocalDateTime timeEnd);
    ResponseEntity<Object> edit(Integer id, PhieuThanhToanDTO dto);
    ResponseEntity<Object> create(PhieuThanhToanDTO dto);
    ResponseEntity<Object> delete(Integer id);
    ResponseEntity<Object> detail(Integer id);
    ResponseEntity<Object> thanhtoan(Integer id);
    ResponseEntity<Object> getPhieuThanhToanCuaThanhNayTheoPhong(Integer soPhong);
}
