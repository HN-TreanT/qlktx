package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.NguoiDungDTO;
import com.qlktx.qlktx.dto.TaiKhoanDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface NguoiDungService {
    ResponseEntity<Map<String, Object>> list(Integer idNhom, String tenNv, String chucVu, int page, int limit);
    ResponseEntity<Object> register(NguoiDungDTO dto);
    ResponseEntity<Object> login(TaiKhoanDTO taiKhoanDTO);
}
