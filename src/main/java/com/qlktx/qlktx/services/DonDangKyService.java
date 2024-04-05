package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.DonDangKyDTO;
import com.qlktx.qlktx.entities.Dondangky;
import com.qlktx.qlktx.payloads.APIResponse;

import java.util.List;

public interface DonDangKyService {
    List<Dondangky> list(String hoTenSinhVien, String doiTuongUuTien);
    APIResponse create(DonDangKyDTO dto);
    APIResponse edit(Integer maDonDangKy, DonDangKyDTO dto);
    APIResponse delete(Integer maDonDangKy);
}
