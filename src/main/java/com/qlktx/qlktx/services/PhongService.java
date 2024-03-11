package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.PhongDTO;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.payloads.APIResponse;

import java.util.List;

public interface PhongService {
    List<Phong> list( Integer soPhong, String soNha, String trangThai);
    APIResponse create(PhongDTO dto);
    APIResponse edit(Integer maPhong, PhongDTO dto);
    APIResponse delete(Integer maPhong);

}
