package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.PhongDTO;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.payloads.APIResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PhongService {
    ResponseEntity<Map<String, Object>> list(Integer soTang, String soNha, String tenPhong, Integer trangThai, int page, int limit);
    ResponseEntity<Object> create(PhongDTO dto);
    ResponseEntity<Object> edit(Integer maPhong, PhongDTO dto);
    ResponseEntity<Object> delete(Integer maPhong);

}
