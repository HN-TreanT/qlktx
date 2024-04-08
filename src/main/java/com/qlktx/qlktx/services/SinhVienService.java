package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.SinhVienDTO;
import com.qlktx.qlktx.entities.Sinhvien;
import com.qlktx.qlktx.payloads.APIResponse;

import java.util.List;

public interface SinhVienService {
    List<Sinhvien> list(String hoTenSinhVien, String GioiTinh, String Khoa);
    APIResponse create(SinhVienDTO dto);
    APIResponse edit(Integer maSinhVien, SinhVienDTO dto);
    APIResponse delete(Integer maSinhVien);
}
