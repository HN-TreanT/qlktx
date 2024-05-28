package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.LoaiPhongDTO;
import com.qlktx.qlktx.entities.Loaiphong;
import com.qlktx.qlktx.payloads.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LoaiPhongService {
    List<Loaiphong> list();
    APIResponse create(LoaiPhongDTO dto);
    APIResponse edit(Integer maLoaiPhong, LoaiPhongDTO dto);
    APIResponse delete(Integer maLoaiPhong);
    ResponseEntity<Object> thogke();

}
