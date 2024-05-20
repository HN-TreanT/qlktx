package com.qlktx.qlktx.services;

import com.qlktx.qlktx.dto.DonDoiPhongDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface DonDoiPhongService {
    ResponseEntity<Object> list(Pageable pageable, Integer maPhong, Integer maSinhvien);
    ResponseEntity<Object> edit(Integer id, DonDoiPhongDTO donDoiPhongDTO);
    ResponseEntity<Object> create(DonDoiPhongDTO donDoiPhongDTO);
    ResponseEntity<Object> delete(Integer id);
    ResponseEntity<Object> detail(Integer id);
}
