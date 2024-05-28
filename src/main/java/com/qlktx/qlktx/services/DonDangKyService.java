package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.DonDangKyDTO;
import com.qlktx.qlktx.entities.Dondangky;
import com.qlktx.qlktx.payloads.APIResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DonDangKyService {
    ResponseEntity<Object> list(String hoTenSinhVien, String doiTuongUuTien, Pageable pageable);
    APIResponse create(DonDangKyDTO dto);
    APIResponse edit(Integer maDonDangKy, DonDangKyDTO dto);
    APIResponse delete(Integer maDonDangKy);
}
