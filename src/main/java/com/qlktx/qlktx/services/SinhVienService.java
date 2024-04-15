package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.SinhVienDTO;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.payloads.APIResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface SinhVienService {
    ResponseEntity<Map<String, Object>> list(int page, int limit , String hoTenSinhVien , String GioiTinh, String Khoa, Integer soPhong);
    APIResponse create(SinhVienDTO dto);
    APIResponse edit(Integer maSinhVien, SinhVienDTO dto);
    APIResponse delete(Integer maSinhVien);
}
