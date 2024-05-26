package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.DonChamDutHopDongDTO;
import com.qlktx.qlktx.dto.DonDoiPhongDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface DonChamDutHopDongService {
    ResponseEntity<Object> list(Pageable pageable, Integer maPhong, Integer maSinhvien);
    ResponseEntity<Object> edit(Integer id, DonChamDutHopDongDTO dto);
    ResponseEntity<Object> create(DonChamDutHopDongDTO dto);
    ResponseEntity<Object> delete(Integer id);
    ResponseEntity<Object> detail(Integer id);
}
