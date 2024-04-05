
package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.HopDongDTO;
import com.qlktx.qlktx.dto.PhongDTO;
import com.qlktx.qlktx.entities.Hopdong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.HopDongRepo;

import java.util.List;

public interface HopDongService {
    public List<Hopdong> list(String trangThai);
    APIResponse create(HopDongDTO dto);
    APIResponse edit(Integer maHopDong, HopDongDTO dto);
    APIResponse delete(Integer maHopDong);

}
