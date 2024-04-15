
package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.HopDongDTO;
import com.qlktx.qlktx.dto.PhongDTO;
import com.qlktx.qlktx.entities.Hopdong;
import com.qlktx.qlktx.entities.Phong;
import com.qlktx.qlktx.payloads.APIResponse;
import com.qlktx.qlktx.repositories.HopDongRepo;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface HopDongService {
     ResponseEntity<Map<String, Object>> list(String tenSinhvien, String trangThai, String timeStart, String timeEnd, int page, int limit);
    APIResponse create(HopDongDTO dto);
    APIResponse edit(Integer maHopDong, HopDongDTO dto);
    APIResponse delete(Integer maHopDong);

}
